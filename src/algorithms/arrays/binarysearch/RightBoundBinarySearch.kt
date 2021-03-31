package algorithms.arrays.binarysearch

/**
 * 这里是取右边界，就是
 * [1,2,2,2,2,2,2]
 * target 2
 * 找到最右边的那个2 是在哪里
 */
fun main() {
    val nums = intArrayOf(1,2,2,2,2,2,2)
    rightBound(nums,2).run {
        println(this)
    }
}

fun rightBound(nums: IntArray, target: Int): Int{
    var left = 0
    var right = nums.size - 1

    while (left<= right) {
        val mid = left + (right - left)/2

        when {
            nums[mid] == target -> left = mid + 1
            nums[mid] < target -> left = mid + 1
            nums[mid] > target -> right = mid -1
        }
    }

    if (right == -1 || nums[right] != target){
        return -1
    }
    return right
}