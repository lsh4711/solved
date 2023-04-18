import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] scores = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) map.put(name[i], yearning[i]);
        for(int i = 0; i < photo.length; i++) {
            int score = 0;
            String[] pho = photo[i];
            for(String p : pho) {
                if(map.get(p) != null) score += map.get(p);
            }
            scores[i] = score;
        }
        
        return scores;
    }
} 