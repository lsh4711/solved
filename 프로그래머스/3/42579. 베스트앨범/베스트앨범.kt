import java.util.HashMap

data class SongInfo(val index: Int, val plays: Int)

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): List<Int> {
        val genreSongsMap = HashMap<String, Int>()
        val genreSongInfosMap = HashMap<String, MutableList<SongInfo>>()
        
        (0 until genres.size).forEach {
            val genre = genres[it]
            val play = plays[it]
            
            genreSongsMap[genre] = (genreSongsMap[genre] ?: 0) + play
            
            val songInfos = genreSongInfosMap[genre] ?: mutableListOf<SongInfo>()
            songInfos.add(SongInfo(it, play))
            genreSongInfosMap[genre] = songInfos
        }
        
        return genreSongsMap.entries
            .sortedByDescending {it.value}
            .flatMap {
                val songInfos = genreSongInfosMap[it.key]!!
                songInfos.sortWith(compareBy({-it.plays}, {it.index}))
                songInfos.take(2).map {it.index}
            }
    }
}