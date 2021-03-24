package algorithms.arrays.two_sum

/**
 * Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.

You may assume that each input would have exactly one solution and you may not use the same element twice.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
 
链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted

 * 一个给定的有序数组，这样的话，一般来说，先考虑双指针，但是又如何考虑前后指针呢？
 * 双指针 labuladong
 * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/2.5-shou-ba-shou-shua-shu-zu-ti-mu/shuang-zhi-zhen-ji-qiao

 */

fun main() {

    val test = intArrayOf(1,5,9,20,30)
    val target = 32

    twoSum(test,target)?.forEach(::println) ?: println("no matched")

}


fun twoSum(nums: IntArray, target: Int): IntArray?{
    var left = 0
    var right = nums.size - 1

    while (left < right){
        val twoSum = nums[left] + nums[right]

        when{
            twoSum == target -> {
                return intArrayOf(left +1 , right +1)
            }

            twoSum < target -> {
                left ++
            }

            twoSum > target -> {
                right --
            }
        }

    }

    return null

}

/**
 * 这好像就是将每个值跟第一个值比了一下
 * 这种对比不对的在于，用了  target - num[left] 去对比 right
 * 本身应该是对比  left 和 right
 * 应该改为  target 与 num[left]  + num[right] 对比
 * 这种情况下，只是一趟对比，但是感觉还是不足够快
 */
fun twoSumFailed(numbers: IntArray, target: Int): IntArray? {

    var left = 0
    var right = numbers.size - 1

    while (left < right){
        if (numbers[right] == target - numbers[left]){
            return intArrayOf(left+1, right+1)
        } else if (numbers[right] > target - numbers[left]){
            right --
        } else if (numbers[right] < target - numbers[left]){
            return null
        }
    }

    return null

}