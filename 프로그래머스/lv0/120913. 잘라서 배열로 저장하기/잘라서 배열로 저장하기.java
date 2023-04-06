class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(my_str.length() - 1) / n + 1];
        
        for(int i = 0, idx = n; i < answer.length; i++, idx += n) {
            int start = idx - n;
            if(idx >= my_str.length()) idx = my_str.length();
            answer[i] = my_str.substring(start, idx);
        }
        
        return answer;
    }
}                     