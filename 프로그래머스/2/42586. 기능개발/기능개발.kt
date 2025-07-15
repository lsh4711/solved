class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): List<Int> {
        val answer = mutableListOf<Int>()
        var days = 0
        var cnt = 0
        
        for ((index, progress) in progresses.withIndex()) {
            val speed = speeds[index]
            val remainProgress = 100 - progress - (speed * days)
                
            if (remainProgress > 0) {
                if (cnt > 0) {
                    answer.add(cnt)
                }
                cnt = 0
                days += ((remainProgress - 1) / speed) + 1
            }

            cnt++
        }
        
        answer.add(cnt)
        
        return answer
    }
}