import kotlin.math.pow
import kotlin.reflect.KFunction

fun main(){
    println(sum(2.0,3.0))
    println(power(2.0,3.0))

    // storing function in variable
    // function is first citizen in kotlin
    // it can be stored in variable , can pass as argument
    var fn: (a: Double, b: Double) -> Double = ::sum
    println(fn(2.0,4.0))

    // higher order function
    calculator(5.0, 5.0, ::sum)

}

fun sum(a:Double, b:Double) : Double{
    return a + b
}

fun power(a:Double , b : Double) : Double{
    return a.pow(b)
}

fun calculator(a:Double, b: Double, gn:(Double, Double)-> Double){
    val result = gn(a,b)
    println(result)
}