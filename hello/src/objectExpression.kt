fun main(){
    var testObj = object{
        val x :Int = 10;
        fun method(){
            println("I am object expression")
        }
    }
    testObj.method()

    // we can create object and inherit interface one time
    var obj = object : Cloneable{
        override fun clone() {
            println("I am clone")
        }
    }
    obj.clone()

    // class
    var obj2 = object :Person4("Sumit"){
        override fun fullName() {
            super.fullName()
            println("Anonymous - $name")
        }
    }
    obj2.fullName()

}

interface Cloneable{
    fun clone()
}

open class Person4 (val name:String){
    open fun fullName() = println("Full name - $name")
}