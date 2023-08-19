class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            sb.append(char1).append(char2);
        }
        
        return sb.toString();
    }
}