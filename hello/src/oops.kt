fun main (){
    val mustang = Car("mustang", "Petrol", 100 )
    val beetle = Car("beetle", "diesel", 200)

    mustang.driveCar()
    println(mustang.name)
    beetle.ApplyBreak()
    println(beetle.KmRan)
}

class Car (val name:String,val type:String, var KmRan:Int ) // Properties
{
    fun driveCar(){ // Method
        println("Car is driving")
    }
    fun ApplyBreak(){
        println("Applied Break")
    }
}