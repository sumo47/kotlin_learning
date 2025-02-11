fun main() {

    val objChild = Child()
    objChild.MyMethod()
    objChild.MyMethod2()
    objChild.name2
    objChild.name
}

open class Parent {
    init {
        println("Parent's Constructor called")
    }

    val name: String = ""

    fun MyMethod() {
        println("I am in Parent")
    }
}

class Child : Parent() {
    init {
        println("Child's Constructor called")
    }

    val name2: String = ""

    fun MyMethod2() {
        println("I am in child ")
    }
}
