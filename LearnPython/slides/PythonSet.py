myset = { "apple", "banana", "cherry" }
myset.add(True)
myset.add(1) # 1 will not add because  the values TRUE/FALSE and 1/0 and considered same and hence duplicates.
print(myset)

thisset = {"apple", "banana", "cherry"}
thisset.add("orange")
print(thisset)

thisset = {"apple", "banana", "cherry"}
tropical = {"pineapple", "mango", "papaya"}
thisset.update(tropical) # adds all
mylist = ["kiwi", "orange"]
thisset.update(mylist)
print(thisset)

"""Remove Item
•Remove() or discard() methods are used to remove an item from a 
set.

•If the item to remove does not exist remove() will raise an error and 
discard will NOT raise an error.

•Wecan also use the pop() method to remove an item, but this 
method will remove a random item, so you cannot be sure what item 
that gets removed.

•Clear() method empties a set.

•Delkeyword will delete the set completely"""
thisset.discard("kiwi")
thisset.pop() # takes no argument
print(thisset)

"""
set3 = set1.union(set2)
set1.update(set2) #saves in set1

x.intersection_update(y) # saves in x

z = x.intersection(y)

x.symmetric_difference_update(y)
Symmetric_difference_update(): will keep only the elements 
that are NOT present in both sets.

"""