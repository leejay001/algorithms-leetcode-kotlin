package algorithms.arrays.binarysearch.apply

import algorithms.common.maxOrNull

/**
 *https://leetcode-cn.com/problems/koko-eating-bananas/
 *875. Koko Eating Bananas
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23


Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109

also linked:
https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484598&idx=1&sn=69edaf4a7f6bfd0b1185cae5d0689c1d&chksm=9bd7fabeaca073a8820bc93cb67a8e26fa9eaa1ab9717b7e3ac41b4aac12235067c8af3520d5&scene=21#wechat_redirect

solve problems with binary search left bound

这种应用题，需要明确的是，在什么中进行查找
像这个就是在 1 到 max中查找，最小的，也就是最左边界
找到之后，right 缩小边界，继续查找
退出的条件是 left = right +1
 *
 */
fun main() {
    val piles = intArrayOf(332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184)
    val H = 823855818
    println(
            minEatingSpeed(piles, H)
    )
}

fun minEatingSpeed(piles: IntArray, H: Int): Int {
    var left = 1
    var right = piles.maxOrNull() ?: 1


    while (left <= right) {
        val mid = left + (right - left) / 2
        if (canFinish(piles, mid, H)) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return left
}


//这里直接看总的时间就好了，在这样的speed 下，是否超过了总时间
fun canFinish(piles: IntArray, speed: Int, H: Int): Boolean {

    var sumTime = 0
    piles.forEach {
        sumTime += timeOf(it, speed)
    }

    return sumTime <= H

}

//这里计算吃每一堆需要消耗的时间，如果有余数就 + 1

fun timeOf(pile: Int, speed: Int) =
        pile / speed + if (pile % speed > 0) 1 else 0





