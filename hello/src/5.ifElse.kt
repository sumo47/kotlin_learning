fun main() {
    val isRain = false

    if (isRain) {
        println("Take Umbrella!")
    } else {
        println("No Rain , Enjoy your day")
    }

    // we can use if-else as a statement in kotlin
    val x = 10
    val y = 11

    var result =
            if (x > y) {
                "x is greater then y"
            } else if (x < y) {
                "x is less then y"
            } else {
                "x is equal to y"
            }

    println(result)

    // Another way to write if-else expression

    val number = 21
    var result2 = if (number % 2 == 0) "even" else "odd"
    println(result2)
}
