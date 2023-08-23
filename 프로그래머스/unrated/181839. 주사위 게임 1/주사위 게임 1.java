class Solution {
    public int solution(int a, int b) {
        int result = 0;
        int r1 = a % 2;
        int r2 = b % 2;
        
        if (r1 + r2 == 2) {
            result = a * a + b * b;
        } else if (r1 + r2 == 1) {
            result = (a + b) * 2;
        } else {
            result = Math.abs(a - b);
        }
        
        return result;
    }
}