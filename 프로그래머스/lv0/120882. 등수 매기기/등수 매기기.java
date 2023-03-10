import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<score.length; i++) {
            answer[i] = score[i][0] + score[i][1];
            list.add(answer[i]);
        }
        list.sort(Comparator.reverseOrder());
        for(int i=0; i<score.length; i++) answer[i] = list.indexOf(answer[i]) + 1;
        
        return answer;
    }
} 