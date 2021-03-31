package algorithms.arrays.binarysearch

/**
 * /**
 *
 * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/2.5-shou-ba-shou-shua-shu-zu-ti-mu/er-fen-cha-zhao-xiang-jie
 * 首先明确一下左侧边界的概念，是不是说target 为2，返回 target 左边的第1位就行了呢
 * 不是
 *  target 不在数组中存在，返回 -1 吗？ 不是
 *
 *  举例
 *  [1,2,2,2,3,4,5] target 为2
 *  那么最开始一定会找到 3旁边的2
 *  那么边界在哪儿呢
 *  是1 右边那个2
 *  返回的下标就是 1
 *  这个 1可以解读为
 * nums 中 小于2的元素有1 个
 *
 * 如果target 为8 ，则会返回7 ，nums 中小于 8 的元素有 7个
 * 那么其实这道题的意思说，nums 中小于 target 的数有几个？
 * 也就是查找 target在nums中的左边界
 *
 * 其实思路一样，就是在找到 target 的时候，不立马返回
 * 让right = mid -1
 * 继续缩小边界
 *
 * 主要还要考虑边界问题
 *
 * 条件是
 * left < = right
 * right = nums.size -1
 *
 * 那么如果 target大于数组中的任何数
 * 那么退出循环的条件就是  right +1
 * 这个时候已经超出数组的长度了
 * 所以，这两点要注意
 *
 *
 *
*/
 */
fun main() {
    val nums = intArrayOf(1,2,2,2,2,2,2)
    leftBound(nums,2).run {
        println(this)
    }

}

fun leftBound(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left)/2

        when {
            nums[mid] == target -> right = mid -1
            nums[mid] > target -> right = mid -1
            nums[mid] < target -> left = mid + 1
        }
    }

    if (left >= nums.size || nums[left] != target){
        return -1
    }

    return left

}