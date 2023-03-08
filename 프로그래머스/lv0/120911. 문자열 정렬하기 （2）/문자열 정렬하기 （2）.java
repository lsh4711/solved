import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String[] strarr = my_string.toLowerCase().split("");
        
        Arrays.sort(strarr);
        
        return String.join("", strarr);
    }
}