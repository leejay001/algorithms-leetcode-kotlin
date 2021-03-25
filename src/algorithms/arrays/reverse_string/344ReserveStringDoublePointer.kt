package algorithms.arrays.reverse_string

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.
 

Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

链接：https://leetcode-cn.com/problems/reverse-string

 */
fun main() {

    val charArray = charArrayOf('h','e','l','l','o')
    reverseString(charArray).forEach(::println)

}

fun reverseString(charArray: CharArray): CharArray{
    var left = 0
    var right = charArray.size - 1
    while (left < right){
        val temp = charArray[left]
        charArray[left] = charArray[right]
        charArray[right] = temp
        left ++
        right --
    }

    return charArray

}