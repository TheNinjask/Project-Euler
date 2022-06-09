import re
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
thready.start()
class Found(Exception): pass
def str2Vec(data:str, count_first_line:bool=False)->List[int]:
  if not count_first_line:
      data = data[1:]
  return list(map(lambda x: int(x),re.findall(r'\d\d\w?', data)))
  

# START CODE
data = """
08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
"""
data:List[int] = str2Vec(data)
high_score:int = 0
def getFourPairingInFront(pos:int, direction:str, width:int=20, height:int=20):
    def horizontal(pos:int, width:int, height:int):
        pairing:[bool, List[int]] = [None,[pos, pos+1, pos+2, pos+3]]
        if pairing[1][0]%width < pairing[1][1]%width < pairing[1][2]%width < pairing[1][3]%width:
            if pairing[1][3]<width*height:
                pairing[0] = True
            else:
                pairing[0] = False    
        else:
            pairing[0] = False
        return pairing
    def vertical(pos:int, width:int, height:int):
        pairing:[bool, List[int]] = [None,[pos, pos+width, pos+2*width, pos+3*width]]
        if pairing[1][0]%width == pairing[1][1]%width == pairing[1][2]%width == pairing[1][3]%width:
            if pairing[1][3]<width*height:
                pairing[0] = True
            else:
                pairing[0] = False 
        else:
            pairing[0] = False
        return pairing
    def majorDiagonal(post:int, width:int, height:int):
        pairing:[bool, List[int]] = [None,[pos, pos+1+width, pos+2+2*width, pos+3+3*width]]
        if pairing[1][0]%width < pairing[1][1]%width < pairing[1][2]%width < pairing[1][3]%width:
            if pairing[1][3]<width*height:
                pairing[0] = True
            else:
                pairing[0] = False
        else:
            pairing[0] = False
        return pairing
    def minorDiagonal(post:int, width:int, height:int):
        pairing:[bool, List[int]] = [None,[pos, pos-1+width, pos-2+2*width, pos-3+3*width]]
        if pairing[1][0]%width > pairing[1][1]%width > pairing[1][2]%width > pairing[1][3]%width:
            if pairing[1][3]<width*height:
                pairing[0] = True
            else:
                pairing[0] = False
        else:
            pairing[0] = False
        return pairing
    func = {
        'horizontal': horizontal,
        'vertical': vertical,
        'majorD': majorDiagonal,
        'minorD': minorDiagonal
    }
    return func.get(direction, None)(pos, width, height)
for dir in ['horizontal', 'vertical', 'majorD', 'minorD']:
    for x in range(0, len(data)):
        pairing = getFourPairingInFront(x, dir, 20, 20)
        if pairing[0]:
            score =  data[pairing[1][0]] * data[pairing[1][1]] * data[pairing[1][2]] * data[pairing[1][3]]
            if score > high_score:
                high_score = score
    result = high_score
# END CODE
doLoad=False
thready.join()
print('\r{}'.format(' '*100), end='')
print('\rResult: {} in {} seconds'.format(result, int(time()-start_time)))
system("pause")
