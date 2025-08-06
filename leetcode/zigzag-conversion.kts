class Solution {
    fun convert(s: String, numRows: Int): String {
        val size = s.length
        val result = CharArray(size)
        var nextIndex = 0

        var ci: Int
        var c: Char
        var isDown: Boolean

        for (row in 0 until numRows) {
            ci = row
            isDown = true

            while (ci < size) {
                c = s[ci]
                result[nextIndex] = c
                nextIndex++

                if (row == 0) {
                    isDown = true
                } else if (row == numRows - 1) {
                    isDown = false
                }

                ci = if (isDown) {
                    ci + maxOf((numRows - 1 - row) * 2, 1)
                } else {
                    ci + maxOf(row * 2, 1)
                }
                isDown = !isDown
            }
        }

        return String(result)
    }
}