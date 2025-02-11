fun main() {
    //    val tile = Red("Mushroom", 25)
    //    val tile2 = Red("Fire", 30)
    //    println("${tile.points} - ${tile.type}")

    val tile: Tile = Red("Mushroom", 25)
    val points =
            when (tile) {
                is Red -> tile.points * 2
                is Blue -> tile.points * 5
            // no need else because it have 2 posibilities only
            }

    println(points)
}

// in enum we restrict for values but in sealed class we restrict for type

sealed class Tile

class Red(val type: String, val points: Int) : Tile()

class Blue(val points: Int) : Tile()
