fun main (){
    dragObjects(arrayOf(Circle(4.0), Square(4.0), Triangle(2.0, 3.0), player("sumit")))

}

fun dragObjects(objects:Array<Draggable>){
    for (obj in objects){
        obj.drag()  // here drag function will not work if Shape class does not exist drag function
    }
}

//interface
interface Draggable{
    fun drag()
    // here drag properties is by default abstract
    // we do not need to override drag() into abstract class , we need to override in normal class 
}
// now we can pass player class into dragObjects as well as shape subclasses

abstract class Shape() : Draggable{ // inherit Draggable interface , now all subclass of shape can access of drag method
    abstract fun area():Double;
}

class Circle(val radius:Double):Shape(){
    override fun area():Double =  Math.PI * radius * radius
   override fun drag() = println("Circle is dragging")
}

class Square(val side:Double):Shape(){
    override fun area(): Double =  side * side
   override fun drag() = println("Square is dragging")
}

class Triangle(val base:Double , val height:Double):Shape(){
    override fun area():Double =  base * height;
    override fun drag() = println("Triangle is dragging")
}

class player(val name:String):Draggable{ // inherit Draggable interface
   override fun drag() = println("$name is dragging")
}
