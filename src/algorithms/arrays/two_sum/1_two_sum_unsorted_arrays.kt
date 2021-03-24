package algorithms.arrays.two_sum

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

链接：https://leetcode-cn.com/problems/two-sum

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

这里一定要注意，能不能直接用一个 for循环
而不是循环两次，
循环两次根本没有必要
一定要保持这种警觉性
在纸上反复演算即可

 */
fun main() {

    val test1 = intArrayOf(3,3)
    val target = 6

    twoSumUnSorted(test1,target)?.forEach(::println) ?: println("no matched")

}

fun twoSumUnSorted(nums: IntArray, target: Int): IntArray? {

    val map = HashMap<Int,Int>()
    nums.forEachIndexed { index, num ->
        val destination = target - num
        map[destination]?.let {
            return intArrayOf(it, index)
        }?: run {
            map[num] = index
        }

    }
    return null
}