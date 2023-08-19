import java.util.Arrays;

class Solution {
    public String[] solution(String my_string) {
        String[] result = new String[my_string.length()];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = my_string.substring(i, result.length);
        }
        Arrays.sort(result);
        
        return result;
    }
}