class Solution {
    public int solution(int[] array) {
        String str = "";
        
        for(int s : array) str += s;
        
        return str.length() - str.replace("7", "").length();
    }
}