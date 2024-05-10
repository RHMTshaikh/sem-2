#  *args and **kwargs=keyword arguments
def myfunc(*kids):
    print(kids[2])

myfunc("aa", "bb", "cc")

def my_function(child3, child2, child1):
    print("The youngest child is " + child3)
    
my_function(child3 = "Emil", child2 = "Tobias", child1 = "Linus")

"""If number of keyword arguments that will be passed
into function is unknown, add ** before the parameter
name. This way the function will receive a
dictionary of arguments."""
def my_function(**kid):
    print("His last name is " + kid["lname"])

my_function(fname = "Tobias", lname = "Refsnes")

# default parametere value
def my_function(country = "Norway"):
    print("I am from " + country)
my_function("Sweden")
my_function("India")
my_function()
my_function("Brazil")

def my_function(x):
    return 5*x
print(my_function(3))
print(my_function("6"))

# Multiple return values
def sum_and_prod(x,y):
    return x + y,  x * y # returns as tuple

sum_and_prod(5, 6)
print(type(sum_and_prod(1,2)))

# pass statemet
def my_function():
    pass


# positional only aarguments
def my_function(x,y,/):
    print(x)

my_function(2,3)

# keyword only argument
def my_function(*,x,y):
    print(x)
    print(y)

my_function(y=3,x=4)
    
# Combine Positional-Only and Keyword-Only
def my_function(a, b, /, *, c, d):
    print(a + b + c + d)
my_function(5, 6, c = 7, d = 8)
