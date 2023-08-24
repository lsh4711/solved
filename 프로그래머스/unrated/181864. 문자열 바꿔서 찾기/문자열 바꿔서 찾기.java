class Solution {
    public int solution(String myString, String pat) {
        boolean isContains = isContains(myString, pat);
        
        if (isContains) {
            return 1;
        }
        return 0;
    }
    
    static boolean isContains(String myString, String pat) {
        label : for (int i = 0; i <= myString.length() - pat.length(); i++) {
            if (myString.charAt(i) == pat.charAt(0)) {
                continue;
            }
            int start = i;
            for (int j = 0; j < pat.length(); j++) {
                if (myString.charAt(start++) == pat.charAt(j)) {
                    continue label;
                }
            }
            return true;
        }

        return false;
    }
}