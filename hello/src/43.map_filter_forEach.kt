fun main() {
    val nums = listOf(1, 2, 3, 4, 5)
    println(isOdd(3))
    println(isOdd(2))

    // passed function inside function
    val list = nums.filter(::isOdd)
    println(list)

    // or
    val list1 =
            nums.filter(
                    fun(a: Int): Boolean {
                        return a % 2 != 0
                    }
            )
    println(list1)
    // or pass lambda function
    val list2 = nums.filter({ a -> a % 2 != 0 })
    println(list2)
    // simplify
    val list3 = nums.filter { a -> a % 2 != 0 }
    println(list3)
    // simplify
    val list4 = nums.filter { it % 2 != 0 }
    println(list4)

    // another example --
    val userList =
            listOf(
                    User(1, "A"),
                    User(2, "B"),
                    User(3, "C"),
            )

    println(userList.filter { it.id == 2 })
    // check if true than return that element

    // Map
    val list5 = nums.map { it * it }

    val paidUserList = userList.map { PaidUser(it.id, it.name, type = "paid") }
    println(paidUserList)

    // forEach
    nums.forEach { println(it) }
}

fun isOdd(a: Int): Boolean {
    return a % 2 != 0
}

data class User(val id: Int, val name: String)

data class PaidUser(val id: Int, val name: String, val type: String)
