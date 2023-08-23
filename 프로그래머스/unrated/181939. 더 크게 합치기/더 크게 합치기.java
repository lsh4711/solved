class Solution {
    public int solution(int a, int b) {
        int ab = a * getNumber(b) + b;
        int ba = b * getNumber(a) + a;
        
        if (ab > ba) {
            return ab;
        }
        return ba;
    }
    
    static int getNumber(int left) {
        int num = 10;
        
        while (num <= left) {
            num *= 10;
        }
        
        return num;
    }
}