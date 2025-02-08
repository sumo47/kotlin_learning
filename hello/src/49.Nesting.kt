fun main() {
    // we will see how to call nested class
    val nested = Outer.Nested()
    nested.test()

    // how to call nested inner class
    val nested2 = Outer2().Nested()
    nested2.test()
}

class Outer {
    var i = 0

    class Nested {
        fun test() {
            // we can not use outer properties in nested(inner) class
            //            println("I am in nested class $i")
            println("I am in nested class ")
        }
    }
}

class Outer2 {
    var i = 0

    inner class Nested {
        fun test() {
            println("I am in nested class with outer properties - $i")
        }
    }
}
