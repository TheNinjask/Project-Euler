from os import system
from time import sleep, time
from threading import Thread
from math import sqrt, ceil

global doLoad
global result 
start_time = time()
doLoad = True
result = None
def loading(start_time=time()):
    global doLoad
    global result
    stringy = ['|','/','-','\\', '|','/','-','\\']
    counter = 0
    while doLoad:
        print('\r', end='')
        print('Loading {} Time Elapsed: {}s Hypothesis: {}'.format(stringy[counter], int(time()-start_time), result), end='')
        if counter < len(stringy)-1:
            counter+=1
        else:
            counter=0
        sleep(0.1)    

thready = Thread(target=loading, args=[start_time])
thready.start()
class Found(Exception): pass
# START CODE
a = 0
b = 0
c = 0
try:
    for partb in range(2, 1000):
        for parta in range(1, partb-1):
            partc = sqrt(parta**2 + partb**2)
            if parta+partb+partc==1000:
                a = parta
                b = partb
                c = partc
                raise Found
except Found:
    pass
result = a * b * c
# END CODE
doLoad=False
thready.join()
print('\r{}'.format(' '*100), end='')
print('\rResult: {} in {} seconds'.format(result, int(time()-start_time)))
system("pause")