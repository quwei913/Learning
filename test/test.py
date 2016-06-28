from SetCache import SetCache
from SetCache import Partitioner
from SetCache import Evictor
import time
class StringPartitioner(Partitioner):
    def get_set(self, setNum, req):
        return len(req) % setNum

class MRUEvictor(Evictor):
    def __init__(self):
        Evictor.__init__(self)
        self.keyName = 'time'

    def store(self, data):
        self.data = data
        self.time = time.time() * -1
        return self


c = SetCache(evictor = MRUEvictor())
print(c.fetch(3))

