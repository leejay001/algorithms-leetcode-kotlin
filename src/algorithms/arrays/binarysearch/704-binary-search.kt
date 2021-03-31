package algorithms.arrays.binarysearch

/**
 * 704. Binary Search
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.



Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Constraints:

1 <= nums.length <= 104
-9999 <= nums[i], target <= 9999
All the integers in nums are unique.
nums is sorted in an ascending order.
```
left = 0
right = ?

while ?

mid = left + (right - left)/2

if(nums[mid] > target){
...
}else if(nums[mid] < target) {
...
}else if(nums[mid] == target) {
...
}

 */
fun main() {

}

fun binarySearch(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1


    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] < target -> left = mid + 1

            nums[mid] > target -> right = mid -1

            nums[mid] == target -> return mid

        }
    }

    return -1
}

/***************************5个条件***************************/
//1. right = nums.size - 1
// 2. 条件是 left < = right
// 3. 相等则 return mid
// 4. 小于，则证明中间的数都比target小，那么只好从右边开始找，那么left = mid +1, mid已经被搜索过，无需left = mid ，直接搜索未搜过的区间
// 5. 大于 ，则证明中间的数都比 target大，那么只好在左边碰碰运气，right = mid -1
