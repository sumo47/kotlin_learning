// fun main(){
//
////    var shape = Shape() // can not create an instance of an abstract class
//
//    val circle = Circle(5.0)
//    println(circle.area())
//    circle.display()
// }
//
// abstract class  A {
//    fun method(){
//        println("withoud abstract properties in abstract class")
//    }
// }
//
// abstract class Shape {
//    var name : String = "";
//    abstract fun area() : Double // we can write properties withoud body using abstract
//    abstract  fun display()
// }
//
//// if we have to abstract properties in abstract class then during inheritance we have to override
// all abstract properties into child class (not sure)
// class Circle(val radius:Double) : Shape(){
//    override fun area():Double = Math.PI * radius * radius
//    override fun display() {
//       println("Circle is getting display")
//    }
//
// }
