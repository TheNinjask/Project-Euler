#4,000,000
import os

cap = 4000000

sum_even = 2

first = 1
second = 2

while second<cap:
    tmp = first+second
    first = second
    second = tmp
    if tmp%2==0:
        sum_even +=tmp

print(sum_even)
os.system("pause")