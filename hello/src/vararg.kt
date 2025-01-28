fun add(vararg values:Int){
    var sum = 0
    for(i in values){
        sum += i
    }
    println(sum)
}


fun main(){
    add(1,2,3,4,) // now we can pass N numbers of argument
    add(1,1,1,1,1,1,1,1,)
}