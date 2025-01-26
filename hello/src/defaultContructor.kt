fun main() {
    val op = Calculator()
    // we call class with constructor without argument
    // kotlin added default constructor parameter-less

    println(op.add(5, 8))
}

class Calculator {

    //    var message:String; // variable must be initialize in class

    fun add(a: Int, b: Int): Int {
        return a + b
    }
    fun multiply(a: Int, b: Int): Int {
        return a * b
    }
}
