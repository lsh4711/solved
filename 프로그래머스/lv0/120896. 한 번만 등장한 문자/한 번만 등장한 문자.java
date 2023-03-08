import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++) {
            if(arr.length-s.replace(arr[i], "").length() == 1) answer += arr[i];
        }
        
        return answer;
    }
}