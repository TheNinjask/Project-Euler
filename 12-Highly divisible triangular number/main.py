import re
import math
from os import system
from time import sleep, time
from threading import Thread
from math import sqrt, ceil, floor
from typing import List

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
class Found(Exception): pass
def str2Vec(data:str, count_first_line:bool=False)->List[int]:
  if not count_first_line:
      data = data[1:]
  return list(map(lambda x: int(x),re.findall(r'\d\d\w?', data)))  
thready.start()
# START CODE
minimum:int = 500
amount = 0
result = 0
def nTriangle(n:int):
    return int(n*(n+1)/2)

while amount <= minimum:
    result += 1
    amount = 0
    factor = nTriangle(result)
    for x in reversed(range(1, (int)(math.sqrt(factor)))):
        if(factor%x) == 0:
            amount += 1

# END CODE
doLoad=False
thready.join()
print('\r{}'.format(' '*100), end='')
print('\rResult: {} in {} seconds'.format(result, int(time()-start_time)))
system("pause")
