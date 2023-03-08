class Solution {
    public int solution(String my_string) {
        String[] strarr = my_string.split(" ");
        int answer = Integer.parseInt(strarr[0]);
        
        for(int i=2; i<strarr.length; i++) {
            if(strarr[i-1].equals("+")) answer += Integer.parseInt(strarr[i]);
            else if(strarr[i-1].equals("-")) answer -= Integer.parseInt(strarr[i]);
        }
        
        return answer;
    }
}