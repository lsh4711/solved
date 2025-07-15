class Solution {
    fun solution(bridge_length: Int, max_weight: Int, truck_weights: IntArray): Int {
        val bridge = ArrayDeque(List(bridge_length) {0})
        var currentWeight = 0
        var passed = 0
        var answer = 0
        var index = 0
        
        while (passed < truck_weights.size) {
            answer++
            
            val passedWeight = bridge.removeFirst()
            
            if (passedWeight > 0) {
                currentWeight -= passedWeight
                passed++
            }
            
            if (index >= truck_weights.size) {
                continue
            }
            
            val weight = truck_weights[index]
            
            if (weight + currentWeight > max_weight) {
                bridge.addLast(0)
            } else {
                bridge.addLast(weight)
                currentWeight += weight
                index++
            }
        }
        
        return answer
    }
}