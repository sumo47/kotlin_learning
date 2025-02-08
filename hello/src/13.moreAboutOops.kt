fun main() {
    var i: Int = 20
    println(i.plus(30))
    println(i.toFloat())

    var P = Person("A", 18)
    var P2 = Person("B", 15)
    println(P.canVote())
    println(P2.canVote())
}

class Person(var name: String, var age: Int) {
    fun canVote(): Boolean = age >= 18
}
