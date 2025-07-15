import java.util.HashMap

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val map = HashMap<String, Int>()
        
        clothes.forEach {
            val category = it[1]
            map[category] = (map[category] ?: 1) + 1
        }
        
        
        var answer = 1
        
        map.forEach {answer *= it.value}
        
        return answer - 1
    }
}