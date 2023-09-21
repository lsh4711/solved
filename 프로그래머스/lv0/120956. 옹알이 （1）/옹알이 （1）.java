class Solution {
    public int solution(String[] babbling) {
        int answer =0;
        
        for(String str : babbling) {
            if(str.replaceAll("aya|ye|woo|ma", "").length() == 0) answer++;
        }
        
        return answer; 
    }
} 