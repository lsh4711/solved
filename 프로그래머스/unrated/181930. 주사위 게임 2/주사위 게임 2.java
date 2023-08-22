class Solution {
    public int solution(int a, int b, int c) {
        if (a != b && a != c && b != c) {
            return a + b + c;
        }
        if (a == b && a == c && b == c) {
            return getResult(a, b, c, 3);
        }
        return getResult(a, b, c, 2);
    }
    
    static int getResult(int a, int b, int c, int cnt) {
        int result = a + b + c;
        
        for (int i = 2; i <= cnt; i++) {
            int sum = getPow(a, i);
            sum += getPow(b, i);
            sum += getPow(c, i);
            result *= sum;
        }
        
        return result;
    }
    
    static int getPow(int num, int cnt) {
        int result = num;
        
        while (--cnt > 0) {
            result *= num;
        }
        
        return result;
    }
}