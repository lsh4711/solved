class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start = total / num + (1-num) / 2;
        
        for(int i=0; i<num; i++, start++) answer[i] = start;
        
        return answer;
    }
}