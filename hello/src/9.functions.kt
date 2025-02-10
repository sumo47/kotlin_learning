fun main() {

    val result = add(5, 6)
    println(result)
    OddOrEven(12)
    OddOrEven(13)
    val res = OneLineAdd(5, 5)
    println(res)
    PrintMessage(5)
    PrintMessage()
}

fun add(num1: Int, num2: Int): Int {
    //   val result = println("Sum of two number $num1 + $num2 = ${num1+num2}");
    val result = num1 + num2
    return result
}

fun OddOrEven(num1: Int) { // this function return Unit type
    val result = if (num1 % 2 == 0) "Even" else "Odd"
    println(result)
}

// one line function
fun OneLineAdd(num1: Int, num2: Int): Int = num1 + num2

// default parameter - if argument passed then it will give result according to argument but if
// argument will not passed then result will print according to default value of parameter
fun PrintMessage(count: Int = 2) {
    // count = 4 // the parameter is val type variable
    for (i in 1..count) {
        println("Hello $i")
    }
}
