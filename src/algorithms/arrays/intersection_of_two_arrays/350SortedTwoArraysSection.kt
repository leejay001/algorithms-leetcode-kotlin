package algorithms.arrays.intersection_of_two_arrays
/**
 * English version
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
*/

/**
 * 这道题是leetcode 350题的进阶版本
 * 就是如果数组是有序的，那么又该如何取优化呢
 *
 * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/2.5-shou-ba-shou-shua-shu-zu-ti-mu/shuang-zhi-zhen-ji-qiao
 *
 *看到数组有序，首先应该想到的是双指针
 * 上面那个链接就是双指针的所有类型了
 *包含了 判断链表是否有环 ，已知链表有环，返回这个环的起始位置
 *
 * 寻找链表的中点
 *
 * 寻找链表的倒数第n个元素
 *
 * 二分查找，两数之和
 * 反转数组
 *
 * 然后更高境界的就是 滑动窗口算法
 *
 * 现在来看，leetcode 350题，数组如果是有序的，如何用双指针解决
 *
 *
 */
fun main() {
    val firstSorted = intArrayOf(1,2,3,4,4,4,5)
    val secondSorted = intArrayOf(2,4,4)
    println(
            intersectSorted(firstSorted,secondSorted)
    )

}

fun intersectSorted(firstSorted: IntArray, secondSorted: IntArray): List<Int> {
    var i = 0
    var j = 0

    val sizeFirst = firstSorted.size
    val sizeSecond = secondSorted.size

//    while (i< sizeFirst && j< sizeSecond ) {
//        if (firstSorted[i] == secondSorted[j]){
//            i++
//            j++
//        }else if (firstSorted[i] < secondSorted[j]){
//
//            i++
//        }else if (firstSorted[i] > secondSorted[j]){
//
//            j++
//        }
//    }
    // 这里主要还是相等情况的处理，相等情况下，才是我们需要的元素
    // 但是如果不 额外开辟空间，又能将这个元素存储下来呢,跟之前的一样
    // 直接用 k ，将 first[k] 存储一下,这道题的精髓就是最后处理等于的情况
    // 记住，有时候需要最后处理等于的情况，双指针

    var k =0
    while (i< sizeFirst && j< sizeSecond){
        if (firstSorted[i] < secondSorted[j]){
            i++
        }else if (firstSorted[i] > secondSorted[j]){
            j++
        }else {
            firstSorted[k] = firstSorted[i]
            i++
            j++
            k++
        }
    }

    return firstSorted.take(k)
}