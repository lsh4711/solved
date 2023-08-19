class Solution {
    public int solution(int a, int d, boolean[] included) {
        int result = 0;
        
        
        for (int i = 0; i < included.length; i++) {
            boolean bool = included[i];
            if(bool) {
                result += a;
            }
            a += d;
        }
        
        return result;
    }
}