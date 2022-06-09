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
bag = []
result = 1
for elem in range(2, 20):
    for item in bag:
        if elem%item==0:
            elem = int(elem/item)
    if elem!=1:
        bag.append(elem)
for elem in bag:
    result *=elem
# END CODE
doLoad=False
thready.join()
print('\r{}'.format(' '*100), end='')
print('\rResult: {} in {} seconds'.format(result, int(time()-start_time)))
system("pause")