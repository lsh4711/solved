import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int l, int r) {
        int start = ((l + 4) / 5) * 5;
        ArrayList<Integer> result = new ArrayList<>();
    
        for (int i = start; i <= r; i += 5) {
            String num = Integer.toString(i);
            if (num.replaceAll("0|5", "").length() == 0) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        
        return result;
    }
}