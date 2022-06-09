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
result = 0
try:
    for plusle in range(999, 100, -1):
        for minun in range(plusle, 100, -1):
            val = plusle * minun
            if result>=val:
                break
            val = str(val)
            if len(val)%2 == 0:
                part1 = val[0:int(len(val)/2)]
                part2 = val[int(len(val)/2):len(val)][::-1]
                if part1 == part2:
                    #result = '{} {}*{}'.format(val, plusle, minun)
                    result = int(val)
            else:
                part1 = val[0:int(len(val)/2)]
                part2 = val[int(len(val)/2+2):len(val)][::-1]
                if part1 == part2:
                    #result = '{} {}*{}'.format(val, plusle, minun)
                    result = int(val)
            
except Found:
    pass
# END CODE
doLoad=False
thready.join()
print('\r{}'.format(' '*100), end='')
print('\rResult: {} in {} seconds'.format(result, int(time()-start_time)))
system("pause")