class Solution {
    public int solution(String myString, String pat) {
        int cnt = 0;
        
        for (int i = 0; i < myString.length(); i++) {
            if (isContains(myString, pat, i)) {
                cnt++;
            }
        }
            
        return cnt;
    }
    
    static boolean isContains(String myString, String pat, int myStringIdx) {
        for (int i = 0; i < pat.length(); i++) {
            if (myStringIdx >= myString.length()
                || pat.charAt(i) != myString.charAt(myStringIdx++)) {
                return false;
            }
        }
        
        return true;
    }
}