fun main() {
    var pizza1: Pizza = Pizza.Factory.create("Peppy Paneer")
    println(pizza1)

    // Here I am calling via Factory reference - don't want to use Factory ref
    // Now after defining that as companion
    var pizza2: Pizza = Pizza.create("Tomato")
    println(pizza2)

    // one more thing we can do - we want everyone to call this create method if they want Pizza
    // for that we will mark the constructor as private
    //    var pizza3 = Pizza() // Now everyone needs to call create method
    //    i.e. everyone has to call factory method
}

// Example of Factory Pattern using Companion

class Pizza private constructor(val type: String, val toppings: String) {
    companion object Factory { // this is my factory object
        fun create(pizzaType: String): Pizza {
            return when (pizzaType) {
                "Tomato" -> Pizza("Tomato", "Tomato , Cheese")
                "Peppy Paneer" -> Pizza("Paneer Farm", "Paneer , Cheese Burst , Tomato , Onion")
                else -> Pizza("Basic", "Onion , Cheese")
            }
        }
    }

    override fun toString(): String {
        return "Pizza(type=$type, toppings = $toppings)"
    }
}
