class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int result = ineq.equals("<") ? m - n : n - m;
        
        if (result > 0 || result == 0 && eq.equals("=")) {
            return 1;
        }
        return 0;
    }
}