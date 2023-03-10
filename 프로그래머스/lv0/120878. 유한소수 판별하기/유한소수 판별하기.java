class Solution {
    public int solution(int a, int b) {
        int n = b;
        
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        n /= a;
        while(n%5 == 0) n /= 5;
        while(n%2 == 0) n /= 2;
        
        if(n == 1) return 1;
        return 2;
    }
}