fun main() {
    val animal = "dog"

    // if-else statement
    //    if(animal == "car"){
    //        println("Animal is cat")
    //    } else if(animal == "lion"){
    //        println("Animal is Lion")
    //    } else if(animal == "dog"){
    //    println("Animal is dog")
    //    } else if(animal == "bear"){
    //    println("Animal is bear")
    //    } else{
    //    println("No Animal found")
    //    }

    // When statement

    when (animal) {
        "cat" -> println("Animal is cat")
        "bear" -> println("Animal is bear")
        "lion" -> println("Animal is Lion")
        "dog" -> println("Animal is Dog")
        else -> println("No animal found")
    }

    val result =
            when (animal) {
                "cat" -> println("Animal is cat")
                "bear" -> println("Animal is bear")
                "lion" -> println("Animal is Lion")
                "dog" -> println("Animal is Dog")
                else -> println("No animal found")
            }
    println(result)

    val number = 15

    val result2 =
            when (number) {
                1 -> "number is 1"
                2 -> "number is 2"
                3 -> "number is 3"
                4 -> "number is 3"
                5 -> "number is 3"
                in 5..15 -> "number is 1 to 15"
                else -> "number not found"
            }
    println(result2)
}
