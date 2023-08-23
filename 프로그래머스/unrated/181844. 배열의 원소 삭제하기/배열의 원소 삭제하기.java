import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        boolean[] visits = new boolean[1001];
        
        for (int num : delete_list) {
            visits[num] = true;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int num : arr) {
            if (!visits[num]) {
                list.add(num);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}