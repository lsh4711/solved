class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val map = HashMap<String, Int>()

        clothes.forEach {
            val (_, type) = it
            val cnt = map.getOrDefault(type, 1) + 1
            map.put(type, cnt)
        }

        return map.values.reduce { acc, i -> acc * i } - 1
    }
}
