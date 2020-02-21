import os

sum = 0
done3 = False
done5 = False
mult = 1
while not done3 or not done5:
    if not done3:
        mult3 = 3*mult
        if mult3 >= 1000:
            done3 = True
        else:
            sum += mult3
    if not done5 and not (mult%3==0):
        mult5 = 5*mult
        if mult5 >= 1000:
            done5 = True
        else:
            sum += mult5
    mult += 1


print(sum)
os.system("pause")