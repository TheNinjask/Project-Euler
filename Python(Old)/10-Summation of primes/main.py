from os import system
from time import sleep, time
from threading import Thread
from math import sqrt, ceil, floor
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
def isPrime(number, primes=[]):
    if number==1:
        return [False, primes]
    elif number<4:
        primes.append(number)
        return [True, primes]
    elif number%2==0:
        return [False, primes]
    elif number<9:
        primes.append(number)
        return [True, primes]
    elif number%3==0:
        return [False, primes]
    else:
        r=floor( sqrt(number) )
        f=5
        while f<=r:
            if number % f ==0:
                return [False, primes]
            if number%(f+2)==0:
                return [False, primes]
            f=f+6
        primes.append(number)
        return [True, primes]
target = 2000000
result = 0
calc = [None, []]
for elem in range(2, target):
    calc = isPrime(elem, calc[1])
    if calc[0]:
        result += elem
# END CODE
doLoad=False
thready.join()
print('\r{}'.format(' '*100), end='')
print('\rResult: {} in {} seconds'.format(result, int(time()-start_time)))
system("pause")