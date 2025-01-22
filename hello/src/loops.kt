fun main() {

    // While Loop
    // ex-1
    var count = 5
    while (count >= 1) {
        println("Hello sumit")
        count--
    }

    // ex-2
    var number = 2
    var index = 1

    while (index <= 10) {
        println(number * index)
        index++
    }

    // Do While Loop
    var count1 = 5
    do { // run do statement firstly then check condition of when
        println("Do While loop")
        count1++
    } while (count1 <= 10)

    // For Loop / Range ( step , downTo)
    println("Step in Range")
    for (i in 1..5 step 2) {
        println(i)
    }
    println("until in Range")
    for (i in 1 until 5) {
        println(i)
    }

    // downTo
    println("downTo in Range")
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
    // String concatenation
    println("Table of 2")
    val number2 = 2
    for (i in 1..10) {
        // println(number2.toString() + " X " + i + " = " + (number2*i))
        // String Templating
        println("$number2 X $i = ${number2 * i}")
    }
}
