fun main() {
    println(S.num)
    T.test()
}

object S {
    val num: Int = 10
}

object T {
    val num2: Int = 20
    fun test() {
        println("I am Object T")
    }
}
