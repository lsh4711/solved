import java.util.Arrays;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        boolean check = true;
        
        for(String[] arr : db) {
            if(Arrays.equals(arr, id_pw)) return "login";
            else if(arr[0].equals(id_pw[0])) check = false;
        }
    
        if(check) return "fail";
        return "wrong pw";
    }
}