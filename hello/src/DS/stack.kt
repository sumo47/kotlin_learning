


class OurStack <T>{

    val storage = arrayListOf<T>()

    override fun toString() = buildString { 
        appendLine("-----Top-----")

        storage.reverse().forEach{
            appendLine("$it")
        }

        appendLine("----------")
     }
}