class Solution {
    public int[] solution(String my_string) {
        int[] ascii = new int[52];
        
        for (char c : my_string.toCharArray()) {
            int idx = -1;
            if (c <= 90) {
                idx = c - 65;
            } else {
                idx = c - 71;
            }
            ascii[idx]++;
        }
        
        return ascii;
    }
}