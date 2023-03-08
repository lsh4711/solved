class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(String i : (Integer.toString(n)).split("")) answer += Integer.parseInt(i);
        
        return answer;
    }
}