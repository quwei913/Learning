import operator
class A(object):
    def __init__(self, data):
        self.data = data
        if self.data == 1: self.order = 10
        if self.data == 2: self.order = -1
        if self.data == 3: self.order = 0

def compare(a):
    return a.getData()

a = {'a':A(1), 'b':A(3), 'c':A(2)}
print (sorted(a, key=lambda x: a[x].'order', reverse=False))