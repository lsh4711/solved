import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            ArrayList<String> list = map.getOrDefault(cloth[1], new ArrayList<>());
            list.add(cloth[0]);
            map.put(cloth[1], list);
        }
        
        ArrayList<ArrayList<String>> clothList = new ArrayList<>();
        
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            clothList.add(entry.getValue());
        }
        
        int total = 1;
        
        for (ArrayList<String> list : clothList) {
            total *= list.size() + 1;
        }
            
        return total - 1;
    }
    
}