pythn

# i=0
# while i<6:
#     i+=1
#     if i==3:
#         continue
#     print(i,"rameex")

# for x in range(2,11,3):
#     print(x)
#     if x==5:
#         break
# else:
#     print("finished")

# adj =["RED","BIF","TASTEY"]
# fruits =["apple","banana","cherry"]

# for x in range(6,0,-1):
#     for y in range(x):
#         pass
#     print((x)*"*")

# for x in range(6,0,-1):
#     print(x)

thislist = ['apple','banana',0]
print(thislist)

thislist = list(('apple','banana','aaloo','kiwi'))
print(thislist)
print(thislist[1])
print(thislist[-1])
print(thislist[2:5])
print(thislist[-5:-2])

if 'apple' in thislist:
    print("yes, apple is in the list")

thislist[2] = 'desi aaloo'
print(thislist) #['apple', 'banana', 'desi aaloo', 'kiwi', 'chiku']

thislist[1:9]  = ['blackcurrant','watermelon',"more",'agian'] #['apple', 'blackcurrant', 'watermelon', 'more', 'kiwi', 'chiku']
print(thislist)

thislist.insert(2,'index2')
print(thislist)
thislist.insert(-2,'index-2')
print(thislist)
thislist.append('last_me')
print(thislist)
dusriList = ['haldi','mirch','dhaniya']
thislist.extend(dusriList)
print(thislist)
thisTuple =('tata','byby')
thislist.extend(thisTuple)
print(thislist)
print(thislist.pop(-1))
print(thislist)
# del thislist
# print(thislist.clear())
for x in thislist:
    print(x)
for i in range(len(thislist)):
    print(thislist[i])

i=0
while(i< len(thislist)-1):
    print(thislist[i] , end=", ")
    i+=1
print(thislist[i])

newlist =[]
for x in thislist:
    if 'a' in x:
        newlist.append(x)
print(newlist)

newlist = [x for x in thislist if 'a' in x]
print(newlist)
newlist = [x for x in thislist ] # condition part is optional
print(newlist)

newlist =  [ x for x in range(10)]
print(newlist)
newlist =  [ x for x in range(10) if x < 5]
print(newlist)

newlist = [x if x!='apple' else 'orange' for x in thislist]
print(newlist)
newlist = [ x.upper() for x in thislist]
print(newlist)
newlist = ['hello' for x in thislist]
print(newlist)
thislist.sort( reverse=True) # this is case sensitive
print(thislist)
thislist.reverse() # this is case sensitive
print(thislist)

mylist = thislist.copy()
print(mylist)

list3 = list1+list2

for x in list2:
    list1.append(x)


pythn

# i=0
# while i<6:
#     i+=1
#     if i==3:
#         continue
#     print(i,"rameex")

# for x in range(2,11,3):
#     print(x)
#     if x==5:
#         break
# else:
#     print("finished")

# adj =["RED","BIF","TASTEY"]
# fruits =["apple","banana","cherry"]

# for x in range(6,0,-1):
#     for y in range(x):
#         pass
#     print((x)*"*")

# for x in range(6,0,-1):
#     print(x)

thislist = ['apple','banana',0]
print(thislist)

thislist = list(('apple','banana','aaloo','kiwi'))
print(thislist)
print(thislist[1])
print(thislist[-1])
print(thislist[2:5])
print(thislist[-5:-2])

if 'apple' in thislist:
    print("yes, apple is in the list")

thislist[2] = 'desi aaloo'
print(thislist) #['apple', 'banana', 'desi aaloo', 'kiwi', 'chiku']

thislist[1:9]  = ['blackcurrant','watermelon',"more",'agian'] #['apple', 'blackcurrant', 'watermelon', 'more', 'kiwi', 'chiku']
print(thislist)

thislist.insert(2,'index2')
print(thislist)
thislist.insert(-2,'index-2')
print(thislist)
thislist.append('last_me')
print(thislist)
dusriList = ['haldi','mirch','dhaniya']
thislist.extend(dusriList)
print(thislist)
thisTuple =('tata','byby')
thislist.extend(thisTuple)
print(thislist)
print(thislist.pop(-1))
print(thislist)
# del thislist
# print(thislist.clear())
for x in thislist:
    print(x)
for i in range(len(thislist)):
    print(thislist[i])

i=0
while(i< len(thislist)-1):
    print(thislist[i] , end=", ")
    i+=1
print(thislist[i])

newlist =[]
for x in thislist:
    if 'a' in x:
        newlist.append(x)
print(newlist)

newlist = [x for x in thislist if 'a' in x]
print(newlist)
newlist = [x for x in thislist ] # condition part is optional
print(newlist)

newlist =  [ x for x in range(10)]
print(newlist)
newlist =  [ x for x in range(10) if x < 5]
print(newlist)

newlist = [x if x!='apple' else 'orange' for x in thislist]
print(newlist)
newlist = [ x.upper() for x in thislist]
print(newlist)
newlist = ['hello' for x in thislist]
print(newlist)
thislist.sort( reverse=True) # this is case sensitive
print(thislist)
thislist.reverse() # this is case sensitive
print(thislist)

mylist = thislist.copy()
print(mylist)

list3 = list1+list2

for x in list2:
    list1.append(x)
