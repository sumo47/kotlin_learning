fun main() {

    // normal class
    val obj = IntContainer(3)
    println(obj.getValue())

    // generic class
    val icontainer = Container(5) // here we can pass all type of value
    println(icontainer.getValue())
    val icontainer2 = Container("Sumit")
    println(icontainer2.getValue())

    // list and map is generic class
    val list = listOf<String>()
}

class Container<T>(var data: T) {
    fun setValue(value: T) {
        data = value
    }
    fun getValue(): T {
        return data
    }
}

class IntContainer(var data: Int) {
    fun setValue(value: Int) {
        data = value
    }
    fun getValue(): Int {
        return data
    }
}

class StringContainer(var data: String) {
    fun setValue(value: String) {
        data = value
    }
    fun getValue(): String {
        return data
    }
}
