class Stack<T> {
    private val storage = arrayListOf<T>()

//    override fun toString() = buildString {
//        appendLine("-----Top-----")
//        storage.reversed().forEach {
//            appendLine("$it")
//        }
//        appendLine("-------------")
//    }

    override fun toString() :String { return "----Top----\n${storage.reversed().joinToString("\n")}\n-----------" }

    // push function
    fun push(element: T) {
        storage.add(element)
    }

    // pop function
    fun pop(): T? {
        return if (storage.size == 0) {
            null
        } else {
            storage.removeLast() // removelast
        }
    }

    // peek
    fun peek(): T? {
        return if (storage.isEmpty()) {
            null
        } else {
            storage[storage.lastIndex]
        }
    }

    // size
    fun size(): Int {
        return storage.size
    }

    // isEmpty
    fun isEmpty(): Boolean {
        return storage.isEmpty()
    }

}