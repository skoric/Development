class Solution {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        var unplacedFruitsCount = 0
        var fruitsFit: Boolean
        var basketCap: Int
        for (i in fruits) {
            fruitsFit = false
            for (j in 0 until baskets.size) {
                basketCap = baskets[j]
                if (basketCap == 0) continue
                if (basketCap >= i) {
                    baskets[j] = 0
                    fruitsFit = true
                    break
                }
            }
            if (fruitsFit) continue
            unplacedFruitsCount++
        }
        return unplacedFruitsCount
    }
}