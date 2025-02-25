import linkedList.Node

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // Stack --------------
//   var stack = Stack<Int>()
//
//   println(stack)
//
//   stack.push(5)
//   stack.push(6)
//   stack.push(7)
//   stack.push(8)
//
//   println(stack)
//
//   var removedElement = stack.pop()
//
//   println("removedElement - $removedElement")
//   println(stack)
//   println("top of the stack is - ${stack.peek()}")
//   println("size of stack - ${stack.size()}")
//   println("isEmpty stack - ${stack.isEmpty()}")

//    ----------Queue----------
//    var queue = Queue<Int>()
//
//    println(queue)
//
//    queue.enqueue(10)
//    queue.enqueue(20)
//    queue.enqueue(30)
//    queue.enqueue(40)
//    queue.enqueue(50)
//
//    println(queue)
//
//    var removeElement = queue.dequeue()
//
//    println("removed Element = $removeElement")
//
//    println(queue)
//    println("Rear is = ${queue.rear()}")
//    println("Front is = ${queue.front()}")
//    println("Queue is Empty or not - ${queue.isEmpty()}")
//    println("size of queue = ${queue.size()}")

    //Linked List ------------------

    var node1 = Node(1)
    var node2 = Node(2)
    var node3 = Node(3)

    node1.nextNode = node2
    node2.nextNode = node3

    println(node1)



}