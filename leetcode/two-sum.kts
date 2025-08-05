class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        var l = 0
        var r = nums.size - 1
        var lnum: Int
        var rnum: Int
        while (l <= r) {
            lnum = nums[l]
            map[lnum]?.let { return intArrayOf(l, it) }
            map[target - lnum] = l

            rnum = nums[r]
            map[rnum]?.let { return intArrayOf(it, r) }
            map[target - rnum] = r

            l++
            r--
        }
        return intArrayOf(0, 0)
    }
}