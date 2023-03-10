class Solution {
    public int solution(int a, int b) {
        int i = b;
        
        while(b != 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        i /= a;
        
        while(i%2 == 0) i /= 2;
        while(i%5 == 0) i /= 5;
        
        return (i == 1) ? 1 : 2;
    }
}