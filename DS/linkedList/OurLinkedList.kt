package linkedList

class OurLinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size: Int = 0

    fun isLinkedListEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isLinkedListEmpty()) {
            "LinkedList is Empty"
        } else {
            head.toString()
        }
    }

    fun push(element: T) {
        head = Node(element, nextNode = head)
        if (tail == null) {
            tail = head
        }
        size += 1

    }

    fun append(element: T) {
        if (isLinkedListEmpty()) {
            push(element)
            return
        }

        tail?.nextNode = Node(element)
        tail = tail?.nextNode
        size += 1

    }

    fun findNodeAt(givenIndex: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < givenIndex) {
            currentNode = currentNode.nextNode
            currentIndex += 1
        }
        return currentNode
    }

    fun insertElement(value: T, afteNode: Node<T>) {
        if (afteNode == tail) {
            append(value)
            return
        }

        val node = Node(value, nextNode = afteNode.nextNode)
        afteNode.nextNode = node
        size += 1
    }

}