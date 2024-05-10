if (5> 2):
    print("jdgvhbnm")

# Type casting
x = 4
print(type(str(x)))
str(x)
int(x)
float(x)

x = 5
y = "John"
print(type(x))
print(type(y))

# string "jhon" or 'jhon' is same
x = "jhon"
y = 'jhon'
if x == y:
    print("both strings are equal")


x, y, z, = "orange", "Banana", "cherry"

x= y= z= "all same"

x= "befor"

def myFunc():
    x = "after"
    print("Python is "+x)

myFunc()
print("Pyhton is "+ x)

# datatypes
# text: str
# numeric: int , float, complex
# sequenece: list, tuple, range
# mapping: dict
# set: set, frozenset
# booleanL: bool
# binary: bytes, byrearray, memeoryview
# None: NoneType

b = b"hello"
b = None
print(b)

import random

for i in range(110):
    print(random.randrange(1,10))#10 excluded
    
# /string is array
a = "hello"
print(a[4])
print(len(a))

for x in "Banana":
    print(x)

txt = "The best things in life are free!"
print("free" in txt) #True
if "free" in txt:
    print("Yes, 'free' is present.")

txt = "The best things in life are free!"
print("expensive" not in txt)

b = "hello world!"
print(b[2:5]) # 5 excluded
print(b[:5]) 
print(b[2:]) 
print(b[-5:-2]) # -2 excluded
print(b[:]) 

a = "hello, world!"
print(a.upper()) # wont change the original text
print(a)
print(a.lower())
print(a.strip()) # removes white spaces
print(a.replace("h","j"))
print(a.split(",")) #['hello', ' world!']

a = "Hello"
b = "World"
c = a + b
print(c)


# print("dfgh"+7)  # error
quantity = 3
itemno = 567
myorder = "I want {} pieces of item {} for dollars."
print(myorder.format(quantity, itemno)) # does not change the original
print(f"I want {quantity} pieces of item {itemno} for dollars.")
print(myorder)

txt = "We are the so-called \"Vikings\" from the" # excape charater with "\"
print(txt)

x = 6
x= x//3 # floor division
print(x)
x &=32 # bitwise AND
x|=3 # bitwise OR
print(x)

a = b =8
c=8
d =5
e =8
print(a is b) # true if same memory location
print(c is b)
print(c is d)
print(e is c)