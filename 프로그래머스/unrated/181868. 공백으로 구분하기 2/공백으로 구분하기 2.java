import java.util.Arrays;

class Solution {
    public String[] solution(String my_string) {
        String[] result = Arrays.stream(my_string.split(" +"))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
            
        return result;
    }
}