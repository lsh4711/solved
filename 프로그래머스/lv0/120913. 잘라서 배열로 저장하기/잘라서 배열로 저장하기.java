class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(my_str.length()-1)/n+1];
        
        for(int i=0, start=0; i<answer.length; i++, start+=n) {
            int end = start + n;
            if(end>my_str.length()) end = my_str.length();
            answer[i] = my_str.substring(start, end);
        }
        
        return answer;
    }
}