class Solution {
    public int solution(int n, long l, long r) {
        long pentaToL = encode(--l);
        long pentaToR = encode(r);
        int oneCntToL = decode(pentaToL);
        int oneCntToR = decode(pentaToR);
        
        return oneCntToR - oneCntToL;
    }
    
    static long encode(long num) {
        long result = 0;
        long exponent = 1;
        
        while (num > 0) {
            long remain = num % 5;
            if (remain == 2) {
                result = result / exponent * exponent;
            }
            result += remain * exponent;
            num = num / 5;
            exponent *= 10;
        }
        
        return result;
    }
    
    static int decode(long num) {
        int[] arr = {0, 1, 2, 2, 3};
        int exponent = 4;
        int result = arr[(int)(num % 10)];
        num /= 10;
        
        while (num > 0) {
            int remain = (int)(num % 10);
            result += arr[remain] * exponent;
            num /= 10;
            exponent *= 4;
        }
        
        return result;
    }
}