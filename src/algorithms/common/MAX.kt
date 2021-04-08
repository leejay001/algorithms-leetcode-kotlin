package algorithms.common

fun IntArray.maxOrNull(): Int? {
    if (isEmpty()) return null
    var max = first()
    forEach {
        if (it > max) max = it
    }

    return max

}

// make sure this array is not empty
fun IntArray.max(): Int {
    var max = this[0]
    forEach {
        if (max < it) max = it
    }

    return max
}