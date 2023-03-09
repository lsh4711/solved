import java.util.Arrays;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        int count = 0;
        
        for(String[] arr : db) {
            if(Arrays.equals(arr, id_pw)) return "login";
            else if(arr[0].equals(id_pw[0])) count = 1;
        }
    
        return count == 1 ? "wrong pw" : "fail";
    }
}