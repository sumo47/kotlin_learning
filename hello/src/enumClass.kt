fun main(){
    val day = Day.SUNDAY
    println(day)
    // write constructor
    println(day.number)
    // we can loop on enum class
    for(i in Day.values()){
        println(i)
    }
    // we can call method
    day.printFormattedDay()

}

enum class Day(val number:Int){
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    fun printFormattedDay(){
        println("Day is $this")
        // this refers to object
    }

}