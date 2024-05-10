# ordered, changeable, duplicate allowed

mylist = ["aa", 'bb', "cc", "dd"]


thislist = ["apple", "banana", "cherry", "apple", "cherry", True, 11, 22]
print(thislist)

#list() constructor
thislist = list(("apple", "banana", "cherry", "apple"))


thislist = ["apple", "banana", "cherry"]
print(thislist[1])

thislist = ["apple", "banana", "cherry"]
print(thislist[-1])

Lst=["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(Lst[2:5])

print(thislist[:4])
print(thislist[2:])
print(thislist[-4:-1])

thislist = ["apple", "banana", "cherry"]
if "apple" in thislist:
    print("Yes, 'apple' is in the fruits list")


thislist = ["apple", "banana", "cherry"]
thislist[1] = "blackcurrant"
print(thislist)
# Change the Range of values
thislist[1:3] = ["blackcurrant", "watermelon"] #['apple', 'blackcurrant', 'cherry']

thislist = ["apple", "banana", "cherry"]
thislist[1:3] = ["watermelon"] #['apple', 'watermelon']

thislist = ["apple", "banana", "cherry"]
thislist.insert(2, "watermelon") # ['apple', 'banana', 'watermelon', 'cherry']
thislist.append("orange") # ['apple', 'banana', 'watermelon', 'cherry', 'orange']

thislist = ["apple", "banana", "cherry"]
tropical = ["mango", "pineapple", "papaya"]
thislist.extend(tropical) # ['apple', 'banana', 'cherry', 'mango', 'pineapple', 'papaya']


thislist = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
thistuple = ("kiwi", "orange") #Tuple
thislist.extend(thistuple) # add any iterable
thislist.remove("apple")
print(thislist.pop(-1)) # returns the poped item
#If you do not specify the index, the pop() method removes the last item
del thislist[0]
print(thislist)
# del thislist # deletes the list
# print(thislist) # error

thislist.clear() # empties the list
print(thislist)

thislist = ["apple", "banana", "cherry"]
for x in thislist:
    print(x)
# Loop Through the Index Numbers Use the range() and len() functions to create a suitable iterable
thislist = ["apple", "banana", "cherry"]
for i in range(len(thislist)):
    print(thislist[i])

fruits = ["apple", "banana", "cherry", "kiwi", "mango"]#list
newlist = []
for x in fruits:
    if "a" in x:
        newlist.append(x)
print(newlist)

# newlist = [expression for item in iterable if condition == True]
newlist = [x for x in fruits if "e" in x]
print(newlist)

newlist = ["expression" for x in fruits if "e" in x]
print(newlist)
newlist = [x for x in fruits] # The condition is optional and can be omitted:

# The iterable can be any iterable object, like a list, tuple, set etc.
# We can use range() function to create iterable:
newlist = [x for x in range(10)]

fruits = ["apple", "banana", "cherry", "kiwi", "mango"]#list
newlist =[x   if x != "banana" else "orange"   for x in fruits]
print(newlist)

thislist = ["orange", "mango", "kiwi", "pineapple", "banana"]
thislist.sort()
print(thislist)
thislist.sort(reverse=True)
print(thislist)

def myfunc(n):
    return abs(n - 50)
thislist = [100, 50, 65, 82, 23]
# Sort the list based on how close the number is to 50
thislist.sort(key = myfunc)
print(thislist)
thislist.reverse()

"""By default the sort() method is case sensitive, resulting 
in all capital letters being sorted before lower case 
letters
•So if you want a case-insensitive sort function, use 
str.lower as a key function:"""
thislist = ["banana", "Orange", "Kiwi", "cherry"]
thislist.sort(key = str.lower)

"""You cannot copy a list simply by typing list2 = list1,
because: list2 will only be a referenceto list1,
and changes made in list1 will automatically also be made in list2."""

thislist = ["apple", "banana", "cherry"]
mylist = thislist.copy() #using copy() method
print(mylist)
thislist = ["apple", "banana", "cherry"]
mylist = list(thislist) #using constructor list
print(mylist*2)