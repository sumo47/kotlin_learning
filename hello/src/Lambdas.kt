fun main() {
    // we write lambda function (anonymous function ) in curly braces
    val lambda1 = { x: Int, y: Int -> x + y }

    // multiline Lambda Function
    val multiLineLambda = {
        println("Hello Lambda")
        val a = 2 + 3
        "Hello Sumit"
        2 // last line of lambda function is return type
    }
    multiLineLambda()
    println(multiLineLambda())

    // single Param Lambda
    val singleParamLambda = { x: Int -> x * x }
    // another way to write lambda expression
    val lambda2: (Int) -> Int = { x -> x * x }
    val lambda3: (Int, Int) -> Int = { x, y -> x * y }
    // here decleare type of lambda2 is fun and , now we don't need to decleare type of function

    // ex
    val sayHi = { msg: String -> println("Hello $msg") }
    val sayHi2: (String) -> Unit = { msg -> println("Hello $msg") }

    // simplyfy single param lambda
    val singleParam: (Int) -> Int = { x -> x + x }
    val simplifySingleParam: (Int) -> Int = { it * it }

    // pass lambda as argument in ways
    calculator(1, 2, { a, b -> a + b })
    calculator(1, 2) { a, b -> a + b } // lambda argument should be moved out of parentheses
}

fun sum(a: Int, b: Int): Int = a + b

fun calculator(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a, b)
} // practice

// * Normal function to Lambda function */
// normal function
fun normalFunction(a: Int, b: Int): Int {
    return a + b
}

// Lambda function
var lambdaFunction = { a: Int, b: Int -> a + b }
