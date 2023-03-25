class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = 0;
        int gcdB = 0;
        
        for(int a : arrayA) gcdA = gcd(gcdA, a);
        for(int b : arrayB) gcdB = gcd(gcdB, b);
        label : for(int i = Math.max(gcdA, gcdB); i > 1; i--) {
            boolean boolA = gcdA % i == 0;
            boolean boolB = gcdB % i == 0;
            if(boolA == boolB) continue;
            int gcdN;
            int[] arrayN;
            if(boolA) {
                gcdN = gcdA;
                arrayN = arrayB;
            } else  {
                gcdN = gcdB;
                arrayN = arrayA;
            }
            for(int n : arrayN) {
                if(n % i == 0) continue label;
            }
            return i;
        }
        
        return 0;
    }
    
    static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
} 