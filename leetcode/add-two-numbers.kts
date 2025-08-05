import kotlin.math.ln1p

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var firstNode = l1
        var secondNode = l2
        var extra = 0
        var result = 0
        var digit = 0

        var resultNode: ListNode? = null
        var currentNode: ListNode? = null

        while (firstNode != null || secondNode != null || extra != 0) {
            // Do something
            result = extra + (firstNode?.`val` ?: 0) + (secondNode?.`val` ?: 0)
            digit = result % 10
            extra = result / 10
            firstNode = firstNode?.next
            secondNode = secondNode?.next

            if (resultNode == null) {
                resultNode = ListNode(digit)
            } else {
                if (currentNode == null) {
                    currentNode = ListNode(digit)
                    resultNode.next = currentNode
                } else {
                    val newNode = ListNode(digit)
                    currentNode.next = newNode
                    currentNode = newNode
                }
            }
        }

        return resultNode
    }
}