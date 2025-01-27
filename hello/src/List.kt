fun main(){
    val nums = listOf(1,2,3)
    println(nums.indexOf(3)) // return index
    println(nums.contains(4)) // boolean
//    nums[1]  = 4 // list is by default immutable , we can not change element

    val list2 = mutableListOf(1,2,3)
    list2[1] = 5;
    println(list2)
    list2.add(6)
    list2.remove(1)
    println(list2)

    val list3 = listOf(11,12)
    list2.addAll(list3)
    println(list2)

    

}
