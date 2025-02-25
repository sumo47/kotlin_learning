package linkedList

fun main() {
    val ourLinkedList = OurLinkedList<Int>()

//    ourLinkedList.push(10)
//    ourLinkedList.push(20)
//    ourLinkedList.push(30)

    ourLinkedList.apply {
        push(10)
        push(20)
        push(30)
    }

    for (i in 1..3) {
        ourLinkedList.append(i)
    }

    println(ourLinkedList)
    println("${ourLinkedList.findNodeAt(2)?.value}")

    val afterNodeRefrence = ourLinkedList.findNodeAt(givenIndex = 3)
    println(afterNodeRefrence)
//    if (afterNodeRefrence != null){
//        ourLinkedList.insertElement(40, afterNodeRefrence)
//    }

    afterNodeRefrence?.also {
        ourLinkedList.insertElement(40, afterNodeRefrence)

    }

    println(ourLinkedList)


}