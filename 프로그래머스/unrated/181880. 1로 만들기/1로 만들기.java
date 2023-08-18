class Solution {
    public int solution(int[] num_list) {
        int[] cnts = new int[31];
        
        for (int i = 2; i <= 30; i++) {
            if (i % 2 == 0) {
                cnts[i] = cnts[i / 2] + 1;
            } else {
                cnts[i] = cnts[i - 1];
            }
        }
            
        int cnt = 0;
        
        for (int num : num_list) {
            cnt += cnts[num];
        }
        
        return cnt;
    }
}