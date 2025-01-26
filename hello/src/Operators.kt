fun main() {
    var i = 13
    var j = 2

    // Arithmetic Operators
    println(i + j) // 15
    println(i - j) // 11
    println(i * j) // 26
    println(i / j) // 6

    // change any one operand to float to give result in float type
    println(i.toFloat() / j) // 6.5
    println(i % j) // 1

    // Relational Operators
    println(i > j) // true
    println(i < j) // false
    println(i >= j) // true
    println(i <= j) // false
    println(i == j) // false
    println(i != j) // true

    // Post and Pre Increment
    // i++ // 14
    // ++i // 14

    println(i++ + ++i) // 13 + 15 = 28

    // Logical Operator
    val above70 = false
    val knowsProgramming = true

    // & AND
    var calledForInterview = above70 && knowsProgramming
    println(calledForInterview)

    // || OR
    calledForInterview = above70 || knowsProgramming
    println(calledForInterview)

    // SHORT OPERATOR // have to explore more
    var s = 10
    var t = 11

    var result = s == 11 || t++ == 11
    println(s)
    println(t)
}
