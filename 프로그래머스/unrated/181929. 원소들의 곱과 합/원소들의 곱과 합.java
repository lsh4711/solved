class Solution {
    public int solution(int[] num_list) {
        int sum1 = 1;
        int sum2 = 0;
        
        for (int num : num_list) {
            sum1 *= num;
            sum2 += num;
        }
        sum2 *= sum2;
        
        if (sum1 < sum2) {
            return 1;
        }
        return 0;
    }
}