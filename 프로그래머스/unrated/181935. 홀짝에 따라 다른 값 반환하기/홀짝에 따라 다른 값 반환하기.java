class Solution {
    public int solution(int n) {
        int r = n % 2;
        int[][] nums = new int[2][n + 2];
        
        nums[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[0][i] = nums[0][i - 2] + i * i++;
            nums[1][i] = nums[1][i - 2] + i;
        }
        
        return nums[r][n];
    }
}