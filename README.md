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
 
  
