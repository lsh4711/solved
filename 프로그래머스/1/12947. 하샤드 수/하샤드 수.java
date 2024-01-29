class Solution {
    public boolean solution(int x) {
        int store = x;
        int num = 0;
        
        while (x > 0) {
            int r = x % 10;
            x /= 10;
            num += r;
        }
        
        return store % num == 0;
    }
}