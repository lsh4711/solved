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
            int start = i;
            for (char charOfPat : pat.toCharArray()) {
                char charOfMyString = myString.charAt(start++);
                if (charOfMyString >= 97) {
                    charOfMyString -= 32;
                }
                if (charOfPat >= 97) {
                    charOfPat -= 32;
                }
                if (charOfPat != charOfMyString) {
                    continue label;
                }
            }
            return true;
        }

        return false;
    }
}