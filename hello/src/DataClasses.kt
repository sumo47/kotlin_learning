fun main (){
    val p1 = Person5(1, "John")
    val p2 = Person5(1, "John")

    println(p1) // toString // here method (toString) of Any class (super class of all class) will be call
    println(p2)
    println(p1.hashCode())
    println(p1 == p2) // p1.equals(p2)

//    output -
//    Person5@7cc355be
//    Person5@6e8cf4c6
//    2093176254
//    false

    // output after data class
//    Person5(id=1, name=John)
//    Person5(id=1, name=John)
//    2314570
//    true

    var p3 = p1.copy()
    p3 = p1.copy(id = 5)
    println(p3)

    val (id, name) = p1
    println(id)
    println(name)

//    println(p1.component1())
    val s = p1.component1()
    println(s)
}

data class Person5(val id:Int, val name:String){

}