class Solution {
    public int solution(int n, String control) {
        int[] directions = new int['w' + 1];
        directions['w'] = 1;
        directions['s'] = -1;
        directions['d'] = 10;
        directions['a'] = -10;
        
        for (char c : control.toCharArray()) {
            n += directions[c];
        }
        
        return n;
    }
}