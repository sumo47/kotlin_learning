fun main() {
    var map = hashMapOf<Int, String>()
    map.put(1, "Sumit")
    map.put(20, "Aman")
    map.put(30, "Abhishek")
    map.put(40, "Nitish")

    println(map.get(30))

    for (i in map.keys){
        println(map.get(i))
    }
    
}