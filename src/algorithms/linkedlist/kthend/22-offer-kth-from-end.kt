package algorithms.linkedlist.kthend

import algorithms.linkedlist.model.ListNode

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/

 * 剑指 Offer 22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。



示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.

注意，这里的k是从1开始的
我们的标号是从0开始的
也就是 k-1

那么这个思路就是：
先将fast 走 k 步，之后再一起同步走，然后 fast 为空的时候，正好slow 在倒数第 k 步
注意输入 【1】进行验证

 */
fun main() {

}

fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {

    var fast = head
    var slow = head

    repeat(k -1 ) {
        if (fast?.next != null) {
            fast = fast?.next
        }

    }

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast?.next
    }

    return slow

}