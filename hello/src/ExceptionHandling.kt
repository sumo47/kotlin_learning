import java.lang.Exception
import java.lang.NullPointerException


fun main(){
    var arr = arrayOf(1,2,3)

    try {
        println(arr[5])
    }
    // we can handle multiple exception
    catch (ex : NullPointerException){

    }
    // we should write base exception in last
    catch (e:Exception){
        println("Please check the array index")
    }
//    finally will call every time
    finally {
        println("I will execute no matter what")
    }

    // throw exception handle
    createUserList(5)
    createUserList(-2)

}

// we can not use try alone
// we can use try with finally

// Throw

fun createUserList(count:Int){
    if(count < 0){
        // Exception raise
        throw IllegalArgumentException("count must be greater than 0")
    }else{
        println("User list created containing $count users")
    }
}