class Solution {
    public long solution(int r1, int r2) {
        long point = 0;
        
        for(long i = 0; i < r2; i++) {
            if(i < r1) point -= (long)Math.ceil(Math.sqrt((long)r1 * r1 - i * i)) - 1;
            point += (long)Math.sqrt((long)r2 * r2 - i * i);
        }
        
        return point * 4;
    }
}        