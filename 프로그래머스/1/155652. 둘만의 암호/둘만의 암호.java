class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
            int cint = s.charAt(i);
            for(int j=1; j<=index;) {
                if(++cint>'z') {
                    cint -= 26;
                }
                if(skip.contains(String.valueOf((char)cint))) {
                    continue;
                }
                j++;
            }
            answer += (char)cint;
        }
        
        return answer;
    }
}