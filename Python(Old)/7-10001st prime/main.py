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
count = 0
stop = 10001
inc = 2
bag = []
while True:
    add = True
    for elem in bag:
        if inc%elem==0:
            add=False
            break
    if add:
        bag.append(inc)
        result = inc # for feedback
        count += 1
        if count == stop:
            result = bag.pop() ### P.S. ???
            break
    inc += 1
# END CODE
doLoad=False
thready.join()
print('\r{}'.format(' '*100), end='')
print('\rResult: {} in {} seconds'.format(result, int(time()-start_time)))
system("pause")