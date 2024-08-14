import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, ArrayList<Integer[]>> songsMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            int count = countMap.getOrDefault(genre, 0);
            countMap.put(genre, count + play);
            
            ArrayList<Integer[]> songs = songsMap.getOrDefault(genre, new ArrayList<>());
            songs.add(new Integer[] {i, play});
            songsMap.put(genre, songs);
        }
        
        String[] bestGenres = countMap.entrySet().stream()
            .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
            .map(Map.Entry::getKey)
            .toArray(String[]::new);
        
        ArrayList<Integer> songList = new ArrayList<>();
        
        for (String genre : bestGenres) {
            ArrayList<Integer[]> songs = songsMap.get(genre);
            if (songs.size() == 1) {
                songList.add(songs.get(0)[0]);
                continue;
            }
            songs.sort((song1, song2) -> song2[1] - song1[1]);
            songList.add(songs.get(0)[0]);
            songList.add(songs.get(1)[0]);
        }
        
        int[] result = new int[songList.size()];
        
        for (int i = 0; i < songList.size(); i++) {
            int song = songList.get(i);
            result[i] = song;
        }
        
        return result;
    }
}