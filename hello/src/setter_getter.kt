fun main() {
    val person = Person3("sumit", 15)
    println("${person.name} is ${person.age} year old")
    person.age = -5
    println("updated age ${person.age}")
}

class Person3(nameParam: String, ageParam: Int) {
    var name: String = nameParam
        // getter function
        get() {
            return field.uppercase()
        }
    var age: Int = ageParam
        // setter function
        set(value) {
            if (value > 0) {
                field = value
            } else {
                println("age can't be negative")
            }
        }
}
