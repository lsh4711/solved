class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = 0;
        int gcdB = 0;
        
        for(int a : arrayA) gcdA = gcd(gcdA, a);
        for(int b : arrayB) gcdB = gcd(gcdB, b);
        
        for(int i = Math.max(gcdA, gcdB); i > 1; i--) {
            label : if(gcdA % i == 0) {
                for(int b : arrayB) {
                    if(b % i == 0) break label;
                }
                return i;
            }
            label : if(gcdB % i == 0) {
                for(int a : arrayA) {
                    if(a % i == 0) break label;
                }
                return i;
            }
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