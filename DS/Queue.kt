class Queue<T> {
    private val storage = arrayListOf<T>()

//    override fun toString() = buildString {
//        appendLine("-----Top-----")
//        storage.reversed().forEach {
//            appendLine("$it")
//        }
//        appendLine("-------------")
//    }

    override fun toString() = buildString {

       return if (storage.isEmpty()){
            "null"
        }
        else{
             "----Queue----\n${storage.joinToString(" , ")}\n-----------"
        }

    }

    // push function
    fun enqueue(element: T) {
        storage.add(element)
    }

    // pop function
    fun dequeue(): T? {
        return if (storage.size == 0) {
            null
        } else {
            storage.removeFirst() // removelast
        }
    }

    // peek
    fun rear(): T? {
        return if (storage.isEmpty()) {
            null
        } else {
            storage[storage.lastIndex]
        }
    }

    fun front(): T? {
        return if (storage.isEmpty()) {
            null
        } else {
            storage[0]
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