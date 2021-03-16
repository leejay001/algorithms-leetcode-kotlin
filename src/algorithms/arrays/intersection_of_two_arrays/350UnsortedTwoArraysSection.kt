package algorithms.arrays.intersection_of_two_arrays

/**
 * 两个数组的交集
 * https://www.geekxh.com/1.0.%E6%95%B0%E7%BB%84%E7%B3%BB%E5%88%97/001.html#_01%E3%80%81%E9%A2%98%E7%9B%AE%E5%88%86%E6%9E%90
 * 同时来自 leetcode 350题 https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 *给定两个数组，编写一个函数来计算它们的交集。
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 *
 * 输出: [2,2]
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *
 * 输出: [4,9]
 *
 *
 * 注意，输出的元素要与 两个数组中出现的最小值一致， 比如第一个例子都是2,2都是出现两次,那后面也必须要出现两次
 *
 * 上面的 4,9 ，第一个数组中只出现一次，第二个数组中出现了两次，那么最小值就是一次
 * 4,和9 只需要出现一次就行
 *
 * 最简单的思路就是 将第一个进行一个map ，key first每个item，value 记录下每个 item 出现的次数
 * 然后对second ，var k = 0
 * 只对 second[item]? 也就是不为空的，找到之后，不用再创建其他空间，还是用 second
 * 放到第k 个位置，并且将此时 map[item] 的值减一
 *
 * 也就是说 对 second item , map[item] 不为空，同时此值应该大于0 的时候
 * second[k] = item k++  map[item] -1 等下次再碰到一样的元素，如果已经减为0 了，就不会再放进去second中了
 */

/**
 * 进阶
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */

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
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 *
 */
fun main() {
    val first = intArrayOf(1, 2, 2, 1)
    val second = intArrayOf(2, 2)
    println(
            intersect(first, second)
    )


}

fun intersect(nums1: IntArray, num2: IntArray): List<Int> {
    val tempMap = HashMap<Int, Int?>()
    nums1.forEach {
        tempMap[it] = tempMap[it]?.plus(1) ?: 1
    }

    var k = 0
    num2.forEach {
        tempMap[it]?.let { value ->
            if (value > 0) {
                tempMap[it] = value - 1
                num2[k] = it
                k++
            }
        }
    }
    return num2.take(k)
}

