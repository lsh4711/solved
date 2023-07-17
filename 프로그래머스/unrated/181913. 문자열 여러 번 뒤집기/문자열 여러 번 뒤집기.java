class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder result = new StringBuilder(my_string);
        
        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            while (a < b) {
                char tmp = result.charAt(a);
                result.setCharAt(a, result.charAt(b));
                result.setCharAt(b, tmp);
                a++;
                b--;
            }
        }
        
        return result.toString();
    }
}