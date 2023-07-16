import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            if (result.size() == 0) {
                result.add(now);
            } else if (now == result.get(result.size() - 1)) {
                result.remove(result.size() - 1);
            } else {
                result.add(now);
            }
        }
        if (result.size() == 0) {
            result.add(-1);
        }
        
        return result;
    }
}