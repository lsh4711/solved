class Solution {
    public String solution(String myString, String pat) {
        int idx = myString.lastIndexOf(pat);
        String result = myString.substring(0, idx + pat.length());
        
        return result;
    }
}