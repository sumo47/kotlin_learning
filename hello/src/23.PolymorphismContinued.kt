// fun main() {

//     val shape = Shape()
//     printArea(shape)

//     val square = Square(4.0)
//     printArea(square) // we can pass all subclass of Shape class
// }
// // CREATED a function that take Shape type data type (class)
// fun printArea(shape: Shape) {
//     println(shape.area())
// }

// open class Shape {
//     open fun area(): Double {
//         return 0.0
//     }
// }

// class Circle(val radius: Double) : Shape() {
//     override fun area(): Double {
//         return Math.PI * radius * radius
//     }
// }

// class Square(val side: Double) : Shape() {
//     override fun area(): Double {
//         return side * side
//     }
// }

// class Triangle(val base: Double, val height: Double) : Shape() {
//     override fun area(): Double {
//         return 0.5 * base * height
//     }
// }
