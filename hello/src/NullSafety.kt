fun main(){
    var gender :String = "Male" // can not assgin null
    var gender2 :String? = null
    var isAdult :Boolean? = null

    if(gender2 != null){
        println(gender2.uppercase())
    }
    println(gender2?.uppercase())

    // we can use Let for more operation perform
    gender2?.let {
        println("Line 1")
        println("Line 2 $gender2")
        println("Line 3 $it") // it points to gender2
    }

    // Elvis operator
    var selectedValue = gender2 ?: "NA"
    println(selectedValue)
//    if gender2 is null than Na will assign in selectedValue

//    if we want error if null value gives by user
    val value = gender2!!.uppercase()
    // not null asser operator = !!
}