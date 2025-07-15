import java.util.PriorityQueue

data class Job(val jobIndex: Int, val requestTime: Int, val workingTime: Int)

class Solution {
    private val queue = PriorityQueue<Job>(compareBy({it.workingTime}, {it.requestTime}, {it.jobIndex}))
    private var currentTime = 0
    private var totalReturnTime = 0
    
    fun solution(jobData: Array<IntArray>): Int {
        val jobs = jobData
            .withIndex()
            .map {Job(it.index, it.value[0], it.value[1])}
            .sortedBy {it.requestTime}
        
        var index = 0
        
        while (index < jobs.size) {
            if (queue.isEmpty() && jobs[index].requestTime > currentTime) {
                currentTime = jobs[index].requestTime
            }
            
            while (index < jobs.size 
                   && jobs[index].requestTime <= currentTime) {
                queue.add(jobs[index++])
            }
            
            process()
        }
        
        while (queue.isNotEmpty()) {
            process()
        }
        
        return (totalReturnTime / jobs.size)
    }
    
    fun process() {
        if (queue.isEmpty()) {
            return
        }
        val job = queue.remove()
        currentTime += job.workingTime
        totalReturnTime += (currentTime - job.requestTime)
    }
}