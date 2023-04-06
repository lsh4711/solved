import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        int[] ascii = new int[123];
        
        for(char c : my_string.toCharArray()) {
            if(c < 91) c += 32;
            ascii[c]++;
        }
        for(int i = 97; i < ascii.length; i++) {
            for(int j = 0; j < ascii[i]; j++) sb.append((char)i);
        }
        
        return sb.toString();
    }
}                          