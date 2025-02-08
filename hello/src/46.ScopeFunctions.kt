fun main() {
    // the way to add properties value
    val emp = Employee()
    emp.age = 20
    emp.name = "John"

    // apply method to add value
    var x =
            emp.apply {
                age = 30
                name = "Seen"
            } // this apply method return
    println(emp)

    // if we want to print properties of employee than we have utility function Let
    println(emp.name)
    println(emp.age)
    // or
    var y =
            emp.let {
                println(it.name)
                println(it.age)
                "hello" // return value of y is string
            } // return value of this scope is last expression value

    // another way to use let
    //    val e :Employee? = null
    val e: Employee = Employee()

    e?.age = 20
    e?.name = "Aman"

    e?.let {
        it.age = 50
        it.name = "john"
    }

    with(e) {
        age = 50
        name = "xyc"
    }
    emp.run {
        age = 35
        name = "PQR"
    }
}

data class Employee(var name: String = "", var age: Int = 18)
