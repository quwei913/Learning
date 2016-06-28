from collections import OrderedDict
class Partitioner(object):
    def get_set(self, size, req):
        raise NotImplementedError('abstract')

class IntegerPartitioner(Partitioner):
    def get_set(self, size, key):
        return key % size

class Collector(object):
    def collect(self):
        raise NotImplementedError('abstract')

class FileCollector(Collector):
    def collect(self, key):
        try:
            with open( "sample.txt" ) as f:
                for line in f.readlines():
                    if line.split(' ')[0] == str(key):
                        return line.split(' ')[1]
        except:
            raise

class ValueGetter(object):
    def getValue(self, dict, key):
        return dict[key]

class LRUValueGetter(ValueGetter):
    def getValue(self, dict, key):
        # try pop to see if a key exists
        value = dict.pop(key)
        # insert back to maintain the order
        dict[key] = value
        return value

class Evictor(object):
    def __init__(self, index):
        self.index = index

    def evict(self, dict):
        del dict[dict.keys()[self.index]]
        return dict

class CustomEvictor(object):
    def __init__(self, sorter, index):
        self.sorter = sorter
        self.index = index

    def evict(self, dict):
        # if need to sort according to member of key or value, sorter should be specified.
        # e.g. if value is a class with a member named color and need to evict color = 'purple'
        # sorter should be "lambda t: t[1].color == 'purple'" and index should be specified -1
        dict = OrderedDict(sorted(dict.items(), key = self.sorter))
        del dict[dict.keys()[self.index]]
        return dict

class SetCache(object):
    def __init__(self, partitioner = IntegerPartitioner(), collector = FileCollector(), sorter = None, index = 0,
                 lru = False, cache_size = 2048, cache_assoc = 2):
        self.cache_size = cache_size
        self.cache_assoc = cache_assoc
        self.num_sets = int(self.cache_size / self.cache_assoc)
        self.cache = [OrderedDict() for _ in range(self.num_sets)]
        self.partitioner = partitioner
        self.collector = collector
        if sorter is None:
            self.evictor = Evictor(index)
        else:
            self.evictor = CustomEvictor(sorter, index)
        # enable lru feature for OrderedDict
        if lru == True:
            self.getter = LRUValueGetter()
        else:
            self.getter = ValueGetter()

    def get(self, key):
        cset = self.partitioner.get_set(self.num_sets, key)
        try:
            # try pop to see if a key exists
            value = self.getter.getValue(self.cache[cset], key)
        except KeyError:
            try:
                # if not there, try to invoke collector to collect data
                value = self.collector.collect(key)
                self.set(key, value)
            except Exception as e:
                print('Failed to get data ' + str(e))
                return None
        return value

    def set(self, key, value):
        cset = self.partitioner.get_set(self.num_sets, key)
        try:
            self.getter.getValue(self.cache[cset], key)
        except KeyError:
            if len(self.cache[cset]) >= self.cache_assoc:
                self.cache[cset] = self.evictor.evict(self.cache[cset])
        self.cache[cset][key] = value


