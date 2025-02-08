fun main(){
    println("Hello Sumit".formattedString())
}

fun String.formattedString() : String{
    return "------------------\n$this\n------------------"
}