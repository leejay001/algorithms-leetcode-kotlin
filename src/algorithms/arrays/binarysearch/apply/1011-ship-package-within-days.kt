package algorithms.arrays.binarysearch.apply

import algorithms.common.maxOrNull
import com.sun.org.apache.xpath.internal.operations.Bool
import java.lang.IllegalArgumentException

/**
 * 1011. Capacity To Ship Packages Within D Days
A conveyor belt has packages that must be shipped from one port to another within D days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.



Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], D = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], D = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1


Constraints:

1 <= D <= weights.length <= 5 * 104
1 <= weights[i] <= 500

also linked :
https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484598&idx=1&sn=69edaf4a7f6bfd0b1185cae5d0689c1d&chksm=9bd7fabeaca073a8820bc93cb67a8e26fa9eaa1ab9717b7e3ac41b4aac12235067c8af3520d5&scene=21#wechat_redirect

In Chinese
传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。

传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。

返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
输出：15
解释：
船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
第 1 天：1, 2, 3, 4, 5
第 2 天：6, 7
第 3 天：8
第 4 天：9
第 5 天：10

请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。

 */
fun main() {
    val weights = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val D = 5

    println(
            shipWithinDays(weights, D)
    )
}

fun shipWithinDays(weights: IntArray, D: Int): Int {
    var left = weights.maxOrNull() ?: 1
    var right = weights.sum()


    while (left <= right) {
        val mid = left + (right - left) / 2
        if (canShip(mid, weights, D)) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return left

}


fun canShip(capacity: Int, weights: IntArray, d: Int): Boolean {

    var i = 0
    repeat(d) {
        var tempCapacity = capacity
        while (tempCapacity >= 0) {
            tempCapacity -= weights[i]
            if (tempCapacity >= 0) {
                i++
            }

            if (i == weights.size) {
                return true
            }

        }

    }

    return false

}



























