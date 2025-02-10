fun main() {

    MyClass.MyObject.f()
    // if we want to call method of object as method of class than we have to use companion while
    // defining object in class
    // now we can write
    MyClass.f()
    MyClass.AnotherObject.g()
}

class MyClass {
    companion object MyObject {
        fun f() {
            println("Hello I am F from Object")
        }
    }

    object AnotherObject {
        fun g() {
            println("Hello I am G from Another Object")
        }
    }
}
