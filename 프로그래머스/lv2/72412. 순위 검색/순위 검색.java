import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] result = new int[query.length];
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        
        for(String i : info) {
            String[] split = i.split(" ");
            int score = Integer.parseInt(split[4]);
            dfs(map, split, "", score, 0);
        }
        for(int i = 0; i < query.length; i++) {
            String[] split = query[i].replaceAll(" and ", "").split(" ");
            ArrayList<Integer> scores = map.get(split[0].replace("-", ""));
            int score = Integer.parseInt(split[1]);
            result[i] = binary(scores, score);
        }
        
        return result;
    }
    
    static void dfs(HashMap<String, ArrayList<Integer>> map, String[] split, String str, int score, int idx) {
        map.putIfAbsent(str, new ArrayList<Integer>(Arrays.asList(-1)));
        map.get(str).add(score);
        
        for(int i = 0; i < 4; i++) {
            if(i >= idx) dfs(map, split, str + split[i], score, i + 1);
        }
    }
    
    static int binary(ArrayList<Integer> scores, int score) {
        if(scores == null) return 0;
        if(scores.get(0) == -1) {
            scores.sort(null);
            scores.set(0, 0);
        }
        int start = 0;
        int end = scores.size();
        
        while(start < end) {
            int mid = (start + end) / 2;
            if(scores.get(mid) < score) start = mid + 1;
            else end = mid;
        }
        
        return scores.size() - start;
    }
}