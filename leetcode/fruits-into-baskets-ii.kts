class Solution {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        var unplacedFruitsCount = 0
        var fruitsFit = false
        for (i in fruits) {
            for (j in baskets.indices) {
                if (baskets[j] != 0 && baskets[j] >= i) {
                    baskets[j] = 0
                    fruitsFit = true
                    break
                }
            }
            if (!fruitsFit) unplacedFruitsCount++
            fruitsFit = false
        }
        return unplacedFruitsCount
    }
}