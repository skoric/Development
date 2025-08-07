class Solution {
    fun isPalindrome(x: Int): Boolean {
        var s = x
        var rev = 0

        while(s > 0){
            rev = rev * 10 + s % 10
            s /= 10
        }
        return rev == x
    }
}