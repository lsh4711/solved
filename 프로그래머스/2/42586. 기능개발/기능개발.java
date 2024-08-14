import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int pointer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while (pointer < progresses.length) {
            int cnt = 0;
            while (pointer < progresses.length && progresses[pointer] >= 100) {
                cnt++;
                pointer++;
            }
            if (cnt > 0) {
                list.add(cnt);
            }
            if (pointer >= progresses.length) {
                break;
            }
            for (int i = pointer; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
        }
        
        int[] result = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}