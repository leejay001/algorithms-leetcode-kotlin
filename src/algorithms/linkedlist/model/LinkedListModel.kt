package algorithms.linkedlist.model

data class Node(var next: Node? = null, var data: Int)

//OR

class ListNode(var data: Int) {
    var next: ListNode? = null
}

//Java version
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */