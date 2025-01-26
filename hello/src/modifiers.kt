fun main() {
    val obj = B()
    println(obj.p)
}

// public modifier
val publicVariable = 10

public fun publicFunction() = println("we don't need to specify public for public modifier")

// internal modifier
internal val internalVariable = 15

internal fun internalFunction() =
        println("This internal funciton can access by another file with in module")

// private modifier
private val privateVariable = 12

private fun privateFunction() = println("this function can access with in file only")

// protected modifier
// not applicable to top level function

open class A {
    public var p = 10
    private var q = 20
    internal var r = 30
    protected var s = 40
}

class B : A() {
    fun test() {
        println(p)
//        println(q) // can not use outside of class for protected properties
        println(r)
        println(s)
    }
}
