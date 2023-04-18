class Solution {
    public long solution(int r1, int r2) {
        return (checkPoint(r2, true) - checkPoint(r1, false)) * 4;
    }
    
    static long checkPoint(int r, boolean b) {
        long cnt = 0;
        
        for(long i = 0; i < r; i++) {
            double sqrt = Math.sqrt((long)r * r - i * i);
            long length = (long)sqrt;
            if(!b && sqrt == length) length--;
            cnt += length;
        }
        
        return cnt;
    }
}  