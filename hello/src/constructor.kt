fun main (){
    var car = AutoMobile("Car",  "Petrol")
    var p = Person2()
    println(p.name)
    println(p.age)
}


class AutoMobile(var name: String, var Tyers:Int, var Seat:Int, var engineType:String) // this is default constructor
{
    // whenever object created init function called
    init { println("$name has bee created") }

    fun drive(){}

    init { println("$Seat available") }

    fun AppliedBreak(){}

    // we have another constructor
    constructor(nameParam:String , engineParam: String) : this(nameParam, 4, 5 , engineParam)
    // now we can pass 2 (name , engineType) or 4 param in class while creating object
}


class Empty{} // this is without constructor class


class Person2() // empty constructor class
{
    val name:String = "Sumit"
    var age:Int = 15
}

