fun main() {
    // var car = AutoMobile("Car", "Petrol")
    // var p = Person2()
    // println(p.name)
    // println(p.age)
    var htc = AutoMobile("htc", "Air")
}

class AutoMobile(
         name: String,
        var Tyers: Int,
        var Seat: Int,
        var engineType: String
) // this is default constructor
// if we do not use var or val than all properties will consider as parameter only , we can't access anymore using obj of this class
{
    // whenever object created init function called
    init { println("$name has bee created")}

    fun drive() {}

    init { println("$Seat available")}

    fun AppliedBreak() {}

    // we have another constructor
    constructor(nameParam: String, engineParam: String) : this(nameParam, 4, 5, engineParam)
    // now we can pass 2 (name , engineType) or 4 param in class while creating object
}

class Empty {} // this is without constructor class

class Person2() // empty constructor class
{
    val name: String = "Sumit"
    var age: Int = 15
}

// we will have to use keyword constructor while using annotation or modifier

// modifier
class Hero private constructor(var name:String){

}l̥

// Annotation
// class Hero1 private @Inject constructor(var name:String){

// }
