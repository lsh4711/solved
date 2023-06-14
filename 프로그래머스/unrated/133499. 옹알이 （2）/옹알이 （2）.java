class Solution {
    public int solution(String[] babbling) {
        int answer =0;
        
        for(String str : babbling) {
            answer += str.replaceAll("aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma)", "").equals("") ? 1 : 0;
        }
        
        return answer;
    }
}