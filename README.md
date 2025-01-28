# kotlin_learning
* What is kotlin?
  - New Programming Language by JetBrains.
  - JetBrains developed softwares like Android Studio, Intellij Idea, Pycharm etc.
  - Targets JVM, Android, Native & JavaScript.
* History of Kotlin
  - In 2011, jetBrains announced the development of Kotlin.
  - Made it open source.
  - 1.0 was made live in 2016.
  - Google IO 2017, Android's first class support for kotlin.
  - In 2019, Android is now Kotlin First.
* Features of Kotlin
  - Statically Typed Language - they check compile time
  - Object oriented and Functional language
  - 100% Interoperable with java
  - Concise, Sage and Powerful - Concise means line of code will less
  - Open Source

* Development Environment
  - For development , we need -
  - Java (atleast JDK 8)
  - IntelliJ Idea (Community Edition)
Note - We will Targeting JVM to learn Kotlin Concept

* Installation process
  - install JDK - jvm + external library
* Agenda
  - Hello world explanation 
  - Compilation
  - Bytecode

* Hello World Program
  - Main is the entry point.
  - JVM looks for this method while running your Program
  ```kotlin 
    fun main(args: Array<String>){
       println("Welcome to CheezyCode")
     }
  ```
# Variable
  - var ca be reassigned.
  - val can't be reassigned.
  
# Data Types
* INTEGER (Byte, Short , Int , Long)
* FLOATING POINT (Float, Double)
* BOOLEAN (True , False)
* CHARACTER (Char , String)
  - we can not assign another data type value into different data type variable
  - single quote for Char use
# Operators
 * Arithmetic Operators
    - `+ - * /` (Maths)
    - Modulus Operator (%)
       - Example - 13 % 2 = 1
    - Integer operation gives result integer only
       - Example - 13 / 2 = 6
 * Relational Operators
    - Greater Than (>)
    - Less Than (<)
    - Greater than Equal To (>=)
    - Less Than Equal To (<=)
    - Equals (==) - Double Equal vs Single Equal
    - Not Equals (!=)
 * Increment and Decrement Operator
    - i++
      - use value of i before increment
    - ++i
      - first increment the value of i then use
    - Similarly, Decrement Operator i-- & --i
 * Logical Operators 
   - &  (AND) 
     - if both condition are true and result will be true
   - || (OR)
     - if one of the condition is true and result will be true
   - !  (NOT)
 * Short circuting
   - if first condition is true than does not evaluate next condetion in or(||) operator
   - if first condition is false then does not evaluate next condition in AND(&) operator
 * Not Operator
   - negate the value
# IF-ELSE
 * If it is raining - take umbrella
 * Otherwise - No Rains - You can enjoy your day
   - if(condition){
   -    run this code if condition is true
   - }
   - else {
   -    run this code if condition is false
   - }
 * we can use if-else as statement in kotlin
# Range (.. & until)
 * .. = 1..5 // 1, 2, 3, 4, 5
 * until = 1 until 5  // 1, 2, 3, 4 
   - upper bond not included
 * downTo = iteration in desending order
    - ex = 
  ```kotlin
  for (i in 10 downTo 1 step 2){
    println(i) // 10 8 6 4 2
  }
  ```
 * Step = inctrement in for loop 
    - ex -
   ``` kotlin
   for (i in 1..5 step 2){
    print(i) // 1,3,5
   }
    ```
# When statement and expression
 * when state is replacement of if-else statement
 * it is readable compare to if=else statement
 * we can use when statement as an expression
# Loops
 * Execute set of statements multiple times
 * E.g. Print hello sumit 5 times
# Function
 * Functions and its different flavors
   - Block of code to perform certain functionality
   - Helps to reuse code
     ```kotlin
     fun methodname
     {
      // Block of code
     }
     ``` 
     ```kotlin
     fun functionName(parameter1:dataType, parameter2:DataType...):ReturnType
     {
      //Block of Statement
      return result
     }
     ```
 * Single Line Function
  ```kotlin
  fun OneLineAdd (num1: Int, num2: Int) : Int = num1 + num2
  ```
 * Default Arguments
```kotlin
  fun PrintMessage(count:Int = 2){
    // count = 4 // the parameter is val type variable
    for (i in 1..count){
        println("Hello $i")
    }
}
```
 * Unit Functions
```kotlin
fun OddOrEven (num1:Int){ // this function return Unit type
    val result = if (num1 % 2 == 0) "Even" else "Odd"
    println(result)
}
```
# Function Overloading
* Function overloading
   - Same Name different parameters
     - Either number of parameters is different
     - Or Type is different
```kotlin
  fun addition (a:Int, b:Int):Int = a+b;

  fun addition (a:Double, b:Double):Double = a+b;
```
* Named Arguments
```kotlin
    val result1 = addition(a = 5,b = 6)
```
* Function Type
  - store function in variable
```kotlin
var fn = ::multiplication;
```
  - store function type explicitly
```kotlin
    var ad  : (a:Double, b:Double) -> Double = ::addition
```
# Array
 * What is and Array
    - Object that stores multiple values of same type
    - Fixed Size 
    - ex - 
```kotlin
var arr = arrayOf("One", "Two", "Three")
```   
 * Use of an Array
     - If I want to store 50 favorite songs of a user
     - Defining 50 variables will be a mess
     - To solve these kinds of problems we have Arrays
* functions of Array
```kotlin
    println(arr[0]) // first element of array will print
    println(arr.get(1)) // second element of array will print
    arr.set(0,"Hello") // frist element will replaced by "Hello"
    println(arr.size) // size of element
``` 
# Classed & Objects
* Classes and Objects
  - OOP - Object Oriented Programming.
  - Paradigm which allows us to solve problems with the help of objects which represents the real world entities.
  - Class is a blueprint of template
  - Objects are the real thing.
  - You creare objects in your program and they interact with each other to complete the work
  - DESIGN A CLASS 
    - Properties of Fields (Object Knows)
    - Methods (Object Does)
    - ex - if we have switch than in class we have -- isOn , Color , Company , On(), Off()
* how to use them in kotlin?
# CONSTRUCTORS
 * Class has 2 things - Properties & Methods
 * Initialize object & provide default values to Properties
 * `init` - create CONSTRUCTOR
 *` constructor` - create default constructor overloading
 * Default Constructor - if we define a class and does not define constructor than kotlin add default paramaeter-less constructor . we call call it like 
```kotlin
val ob = calculator()
```
 * Getter Setter
   - whenever we write Properties in class , kotlin bind getter and setter function into it (set(value), get() = field)
   - in class we use set function to set the value of variable -
   - for getter function we use get function 
   - eg - 
```kotlin
  class Person(nameParam:String, ageParam:Int){

    // getter
    var name:String = nameParam
    get(){
      return field = toUpperCase()
    }

    // setter 
    var age:Int = ageParam // dont terminate this line using ; (semicolon)
    set(value){
      if(value > 0){
        field = value
      }else{
        println("Age can't be negative")
      }
    }
  }
```

 * lateinit - 
   - variable must be Initialize in class
   - with the help of lateinit we can create variable without Initialize
   - eg - 
```kotlin
lateinit var message:String;
```
# INHERITANCE
 * What is INHERITANCE
   - Literal meaning - derive ( a quality , characteristic, or pradiposition ) genetically from one's parents or ancestors.
   - ex - 
     - Car is a Vehicle, Truck is a Vehicle
       - we can create parent class for Vehicle and child class for Car and Truck
     - Square is a Shape, Circle is a Shape
     - Cat is an Animal, Dog is an Animal
     - Saving Account, Current Account, Credit Card Account
     - Full Time Employee, Part Time Employee
   - in kotlin only one parent exist for child 
 * syntax 
   - open keyword (class A:B())
 * Summary
   - Code Reusability
   - cannot inherit from multiple Classes
   - Parent class constructor is called before child class
# Overriding
 * Overriding
   - which fun/properties want to override we should mark open with `open` keyword
```kotlin
open class Mobile(){
  open val name : String = ""; // properties can be override
  open fun display() = println("Simple Mobile display") // function can now able to override in child class
}
```
   - where we want to override we have to use override keyword 
```kotlin
class OnePlus : Mobile(){
    override val name:String = "OnePlus mobile"; // OnePlus mobile 
    override fun display() = println("OnePlus display") // OnePlus display
}
```
 * Calling Parameterized Contructores
   - if we inherit any Parameterized class than we have to write all parameterized properties in child class
   - ex - 
```kotlin
open class Mobile(val type:String){}

class OnePlus : Mobile("SmartPhone"){}
```
   - we can dynamicaly pass parameter in parent class
```kotlin
open class Mobile(val type:String){}

class OnePlus(typeParam:String) : Mobile(typeParam){}
```
  - `super` - we can use parent properties in child class using `super` keyword
```kotlin
open class Mobile(){ // parent class
  open fun display() = println("Simple Mobile Display")
}
class OnePlus : Mobile(){ // child class
  override fun display(){
    super.display() // Simple Mobile Display
    println("OnePlus Display")
  }
}
```
 * Getter/Setter Override
 * Any Type
   - Yes, in Kotlin, the superclass of all classes is Any. 
   - If you don't specify a superclass explicitly, your class will implicitly inherit from Any.
   - Any provides three methods: `equals()`, `hashCode()`, and `toString()`.
   - Therefore, all Kotlin classes have these methods by default.
   - override `toString()`
```kotlin
override fun toString(): String {
  return "Name - $name - Size - $size"
}
```
# Polymorphism 
* what is Polymorphism ?
   - parent can hold refrence to it's child and call method to it's child classes
   - parent can call methods of child classes (which are common)
* Advantages of Polymorphism
  - Helps to write Maintainable & Extensible Code 
  - helps in interacting with objects via common interface
  
# Polymorphism more
* More about Polymorphism
   * Poly means Many & Morph means Form
   * In computer Science, it is defined as - method name is some but it will behave differently based on the object.
   * INHERITANCE & POLYMORPHISM
    - IS-A relationship (Circle is a Shape)
    - So whereever Shape is required, we can any of subclasses i.e. we can easily pass Circle, Square or Triangle. Because they all inherit from Shape
    - but we cannot pass Shape Object where Circle is require. Because all shapes are not circle.
* method Calling
   - when we call any method , compiler checks firstly in `subclass` and then checks in `Superclass` then checks in `Any` class
   - Any <--- SuperClass <--- SubClass
  
# Abstract Class
 * Abstract Class
 * Need of Abstract Class
 * Abstract methods
   - Class ( Abstract class ) can't be instantiated
   - Abstract class can have both abstract and not abstract properties & methods
   - if a class has abstract method or property then class must be declared as abstract
  
# Interface
* Interface
* Need of Interface
* Polymorphic Behavior
  - Group objects based on what they can do rather than what they are.
  - To use polymorphism in unrelated set of classes (i.e. classes which do not belong to same inheritance hierarchy)
  - Common Terminology - Interface is a contract which states that whoever implements that interface has to provide the implementation for the methods.
  - Interfaces are meant for behaviors. Classes which exihibits  that behavior implements that interface.
  - Interface can have both abstract and concrete methods.
  - Interface can implement other interfaces and one class can implement many interface but class can have only one superclass.

# Type Checking & Smart Casting

# Visibility Modifiers
* Top level declarations
  * Public - 
    - Everywhare
  * Internal
    - with in a module ( with in project)
  * Protected
    - With in file
  * Private
    - N/A
* Class Members
  * Public - 
    - Everywhare
  * Internal
    - with in a module
  * Protected
    - With in class
  * Private
    - Subclasses
  
# Object 
 * object keyword
 * Object Declaration and Expression
   - Class and it's Single Object is created at once.
   - No constructors are allowed (init block is allowed)
   - Singleton Pattern
     - is use to create single object
   - You can inherit class/interface.
 * Object Expression
   - Anonymous Objects using object keyword.
   - Replacement of java's Anonymous Inner Class.
# Companion 
  * companion keyword
```kotlin
class MyClass{
    companion object MyObject {
        fun f(){
            println("Hello I am F from Object")
        }
    }
}
```

  * Need of Companion Object
    - now we can call method of object as method of class
    - only one companion allowed in class 
    - `MyClass.MyObject.f() = MyClass.f()`
  * @JvmStatic
```kotlin
 companion object MyObject {
 @JvmStatic
 fun f(){
            println("Hello I am F from Object")
        }
 }
```
  - now in java we can use this companion object method as static  
# Data Classes
 - when we defining the data classes it should carry atleast one primary constructor
 * `equals()` , `toString()` , `hashCode()` of Any Class
    - `equals()` = in data classes if data is same then equals() return true
    - `toString()` = in data class when we print object of class without overriding toString() in class then properties will print
    - `hashCode()` = it is function that uniquely identify object 
 * Copy funciton  - we can copy a object to another variable 
```kotlin
var p3 = p1.copy()
p3 = p1.copy(id = 5)
```

 * `componentN()` - 
   - destructure object - 
```kotlin
val (id, name) = p1
val id = p1.component1()
```
# Enum classes , Sealed Classes
* we can assign set of constant value in variable
```kotlin
enum class Day{
  SUNDAY,
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY
}
```
* Sealed class restricted for type 
```kotlin
sealed class Tile
class Red(val type:String, val points:Int): Tile()
class Blue (val points: Int):Tile()
```
# Null Safety 
* Null Safety - Nullable & Non Nullable Types
* Safe call operator (?.) with let
* Not Null Asserted & Elvis Operator
   - we use ? in after type `var gender : String?` so variable can accept null value
   - if we want to use nullable variable or apply method on it we should use safe call operator (?.) `gender?.uppercase()`
   - when we want error if null value gives by user , we use Not Null Assert operator = `!!`
```kotlin
    var selectedValue = gender2 ?: "NA"
```
   - if we want some default value if null is given by user than we use Elvis operator = `?.`
```kotlin
    val value = gender2!!.uppercase()
```

# Exception Handling
* Try catch Finally
* Throw Exceptions

# List & Map
* List & Mutable List
   - Mutable List( Can be changed i.e. elements can be added/removed/replaced)
   - Immutable List(Can't be changed)
   - 
* Map & Mutable Map
  - key value pair
  - Mutable and Immutable
  
# higher Order Functions & Lambdas
 * Function that accepts functions as an argument or return funcitons or both
 * Lambdas or Lambda Expression
   - Different variation of Lambdas
   - ex - normal function 
```kotlin
// this is normal function
fun sum(a:Int, b:Int):Int
{
  return a+b
}
// this is lambda expression
val sum = {a:Int , b:Int -> a+b}
```

# Collection Functions - .forEach(), .map(), .filter()
* User of Lambdas
# Extension Function & Inline Function 
 - we can add method in class 
```kotlin
fun main(){
  println("Hello Sumit".formattedString())
}

fun String.formattedString() : String{
    return "------------------\n$this\n------------------"
}
//output 
------------------
Hello Sumit
------------------
```
* Inline function 

# Scoped Functions - Utility Function (apply , let , with , run)

# Introduction to Generics
 * it is type of class where we defice `type` and return type while creating object
 * general class that is not type dependent , we pass type here , in future any type come , it behaves same
 * list and map is generic class 
# vararg
 * we can pass N numbers of value , vararg will wrap all values in array
 * ex - 
```kotlin
fun add(vararg values:Int){
  var sum = 0
  for(i in values){
    sum += i
  }
  println(sum)
}
fun main(){
  add(1,2,3,4,) // now we can pass N numbers of argument
}
```

# Nested Classes $ Inner Class
* we can create class inside class 
* we can call inner class directly 
* we can not access properties of outer class into inner class 
* to access properties of outer class we have to use `inner` keyword in inner class , 
    - now we have to create object of outer class than we can call inner class
* ex - without `inner` keyword
```kotlin
class 
