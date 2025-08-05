class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var l = 0
        var res = 0
        val currentChars = mutableSetOf<Char>()

        for (r in s.indices) {
            while (s[r] in currentChars) {
                currentChars.remove(s[l])
                l++
            }
            currentChars.add(s[r])
            res = maxOf(res, r - l + 1)
        }

        return res
    }
}