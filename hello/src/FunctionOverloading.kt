fun main(){
    val result1 = addition(a = 5,b = 6)
    val result2 = addition(5.6,8.7)

    // store function in variable
    var fn = ::multiplication;
    // store function type explicitly
    var ad  : (a:Double, b:Double) -> Double = ::addition

    println(ad(5.4,4.6))
    println(fn(5,4))
    println(result1)
    println(result2)

}
fun addition (a:Int, b:Int):Int = a+b;

fun addition (a:Double, b:Double):Double = a+b;

fun multiplication (a:Int, b:Int):Int = a*b;

