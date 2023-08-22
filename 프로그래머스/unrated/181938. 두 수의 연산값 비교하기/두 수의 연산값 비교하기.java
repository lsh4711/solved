class Solution {
    public int solution(int a, int b) {
        int num = 10;
        
        while (num <= b) {
            num *= 10;
        }
        
        return Math.max(a * num + b, a * b * 2);
    }
}