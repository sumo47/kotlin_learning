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
   - 