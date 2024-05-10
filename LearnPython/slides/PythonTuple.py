#  Tuple items are ordered, unchangeable, and allow duplicate values.
"""To create a tuple with only one item, you have to add a comma
after the item, otherwise Python will not recognize it as a tuple."""
thistuple = ("apple",)

thistuple = tuple(("apple", "banana", "cherry")) 
# follows usual indexing slicing
if "apple" in thistuple:
    print("yes")

thistuple = list(thistuple)
thistuple[0] = "kiwi"
thistuple = tuple(thistuple)
print(thistuple)


thistuple = ("apple", "banana", "cherry")
y = ("orange",)
thistuple += y
# del thistuple
print(thistuple)

fruits = ("apple", "banana", "cherry")
(green, yellow, red) = fruits
print(green)
print(yellow)
print(red)

fruits = ("apple", "banana", "cherry", "strawberry", "raspberry")
(green, yellow, *red) = fruits
print(green)
print(yellow)
print(red) # ['cherry', 'strawberry', 'raspberry']

fruits = ("apple", "banana", "cherry", "strawberry", "raspberry")
(green, *tropic, red) = fruits
print(green)
print(tropic) # ['banana', 'cherry', 'strawberry']
print(red)


# join Tuples
tuple1 = ("a", "b" , "c")
tuple2 = (1, 2, 3)
tuple3 = tuple1 + tuple2
print(tuple3)
# Multiply Tuples
fruits = ("apple", "banana", "cherry")
mytuple = fruits * 2
print(mytuple)