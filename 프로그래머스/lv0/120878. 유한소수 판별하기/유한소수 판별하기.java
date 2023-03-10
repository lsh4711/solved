class Solution {
    public int solution(int a, int b) {
        while(b%5 == 0) b /= 5;
        while(b%2 == 0) b /= 2;
        
        if(a%b == 0) return 1;
        return 2;
    }
} 