class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_strings.length; i++) {
            String my_string = my_strings[i];
            int[] part = parts[i];
            int s = part[0];
            int e = part[1] + 1;
            sb.append(my_string.substring(s, e));
        }
        
        return sb.toString();
    }
}