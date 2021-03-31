package algorithms.linkedlist.middle

import algorithms.linkedlist.model.ListNode

/**
 *
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *876. Middle of the Linked List
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.


Note:

The number of nodes in the given list will be between 1 and 100.

 基于链表II，我们得出一个结论
 就是
 fast = fast.next.next
 slow = slow.next
 当 fast 走完的时候， slow 刚好走到一半
 也就是说 slow 走了 k
 fast 走了 2k
 稍微演算
 */
fun main() {

}

fun middleNode(head: ListNode?): ListNode? {

    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}