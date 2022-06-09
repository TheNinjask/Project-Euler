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
# START CODE
def isPrime(number, primes=[2]):
    if number<2:
        return [False, primes]
    if number==2:
        return [True, primes]
    for elem in primes:
        if number%elem==0:
            return [False, primes]
    primes.append(number)
    return [True, primes]

target = 600851475143
cap = target
calc = [None, [2]]
for elem in range(2, target):
    calc = isPrime(elem, calc[1])
    if calc[0] and cap%elem==0:
        result = elem
        cap = cap/elem
    if cap<elem:
        break
# END CODE
doLoad=False
thready.join()
print('\r{}'.format(' '*100), end='')
print('\rResult: {} in {} seconds'.format(result, int(time()-start_time)))
system("pause")