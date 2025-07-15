import java.util.PriorityQueue

data class Process(val index: Int,val priority: Int)

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val pq = PriorityQueue<Int>(priorities.size, compareBy { -it })
        pq.addAll(priorities.asList())
        
        val processes = priorities.withIndex().map {Process(it.index, it.value)}
        val queue = ArrayDeque<Process>(processes)
        var answer = 0
        
        while (queue.isNotEmpty()) {
            val process = queue.removeFirst()
            val (index, priority) = process
            
            if (priority != pq.element()) {
                queue.add(process)
                continue;
            }
            
            pq.remove()
            answer++
            
            if (index == location) {
                return answer
            }
        }
        
        return answer
    }
}