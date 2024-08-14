import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            ArrayList<String> list = map.getOrDefault(cloth[1], new ArrayList<>());
            list.add(cloth[0]);
            map.put(cloth[1], list);
        }
        
        int total = 1;
        
        for (ArrayList<String> list : map.values()) {
            total *= list.size() + 1;
        }
            
        return total - 1;
    }
    
}