import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[][] solution(int[][] datas, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int extIdx = map.get(ext);
        int sortIdx = map.get(sort_by);
        ArrayList<int[]> list = new ArrayList<>();
        
        for (int[] data : datas) {
            if (data[extIdx] < val_ext) {
                list.add(data);
            }
        }
        list.sort((a1, a2) -> a1[sortIdx] - a2[sortIdx]);
        
        return list.toArray(int[][]::new);
    }
}