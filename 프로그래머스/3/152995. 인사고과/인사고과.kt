class Solution {
    fun solution(scores: Array<IntArray>): Int {
        val wanhoScore = scores.first()

        scores.sortWith { score1, score2 ->
            when (score1.first() != score2.first()) {
                true -> score2.first() - score1.first()
                false -> score2.last() - score1.last()
            }
        }

        val group = scores.groupBy { it.first() }.toList()
        var maxPeerReview = 0
        val list = ArrayList<IntArray>()

        for ((attitude, scores) in group) {
            scores.forEach {
                if (it.last() >= maxPeerReview) {
                    list.add(it)
                }
            }
            maxPeerReview = Math.max(maxPeerReview, scores.first().last())
        }

        list.sortByDescending { it.sum() }

        var previousSum = -1
        var rank = 0

        for ((idx, score) in list.withIndex()) {
            val sum = score.sum()
            if (sum != previousSum) {
                previousSum = sum
                rank = idx + 1
            }
            if (score == wanhoScore) {
                return rank
            }
        }

        return -1
    }
}