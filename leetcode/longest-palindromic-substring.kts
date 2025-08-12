class Solution {
    fun longestPalindrome(s: String): String {
        if (s.length < 2) return s

        var longestSubstring = s[0].toString()

        var tempLeft: Int
        var tempRight: Int
        var f: Int
        var t: Int
        for (i in 0 until s.length-1) {
            if (i < s.length - 2 && s[i] == s[i+2]) {
                tempLeft = i
                tempRight = i+2
                f = tempLeft
                t = tempRight

                tempLeft--
                tempRight++

                while (tempLeft >= 0 && tempRight < s.length && s[tempLeft] == s[tempRight]) {
                    f = tempLeft
                    t = tempRight

                    tempLeft--
                    tempRight++
                }

                if (t-f+1 > longestSubstring.length) {
                    longestSubstring = s.substring(f, t + 1)
                }
            }

            if (s[i] == s[i+1]) {
                tempLeft = i
                tempRight = i+1
                f = tempLeft
                t = tempRight

                tempLeft--
                tempRight++

                while (tempLeft >= 0 && tempRight < s.length && s[tempLeft] == s[tempRight]) {
                    f = tempLeft
                    t = tempRight

                    tempLeft--
                    tempRight++
                }

                if (t-f+1 > longestSubstring.length) {
                    longestSubstring = s.substring(f, t + 1)
                }
            }
        }

        return longestSubstring
    }
}

println(Solution().longestPalindrome("cbbd"))