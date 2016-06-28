from SetCache import SetCache
from SetCache import Partitioner
class StringPartitioner(Partitioner):
    def get_set(self, setNum, req):
        return len(req) % setNum

# MRU cache
c = SetCache(index = -1, lru = True)
print(c.get(3))
# LRU cache
c1 = SetCache(lru = True)
print(c1.get(1))
# second LRU cache
c2 = SetCache(index = 1, lru = True)
print(c2.get(1))
# FIFO cache
c3 = SetCache(index = 0)
print(c3.get(3))


