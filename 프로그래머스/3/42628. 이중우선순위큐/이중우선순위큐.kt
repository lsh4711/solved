import java.util.PriorityQueue

class Solution {
    private val minHeapQueue = PriorityQueue<Int>()
    private val maxHeapQueue = PriorityQueue<Int>(compareBy {-it})
    private val map = HashMap<Int, Int>()
        
    fun solution(operations: Array<String>): IntArray {
        
        
        operations.asSequence()
            .map {it.split(" ")}
            .forEach {
                val operation = it[0]
                val num = it[1].toInt()
                
                if (operation == "I") {
                    add(num)
                    return@forEach
                }
                
                if (num == 1) {
                    remove(maxHeapQueue)
                } else {
                    remove(minHeapQueue)
                }
            }
        
        return intArrayOf(element(maxHeapQueue), element(minHeapQueue))
    }
    
    fun add(num: Int) {
        minHeapQueue.add(num)
        maxHeapQueue.add(num)
        map[num] = (map[num] ?: 0) + 1
    }
    
    fun remove(queue: PriorityQueue<Int>) {
        cleanGargage(queue)
        
        if (queue.isEmpty()) {
            return
        }
        
        val num = queue.remove()
        
        map[num] = (map[num] ?: 1) - 1
        
        if (map[num] == 0) {
            map.remove(num)
        }
    }
    
    fun element(queue: PriorityQueue<Int>): Int {
        cleanGargage(queue)
        return when (queue.isEmpty()) {
            true -> 0
            false -> queue.element()
        }
    }
    
    fun cleanGargage(queue: PriorityQueue<Int>) {
        while (queue.isNotEmpty() && map[queue.element()] == null) {
            queue.remove()
        }
    }
}