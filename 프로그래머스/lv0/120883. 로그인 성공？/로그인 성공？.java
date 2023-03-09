class Solution {
    public String solution(String[] id_pw, String[][] db) {
        boolean id = false;
        
        for(String[] arr : db) {
            if(id_pw[0].equals(arr[0]) && id_pw[1].equals(arr[1])) return "login";
            if(id_pw[0].equals(arr[0])) id = true;
        }
        
        if(!id) return "fail";
        return "wrong pw";
    }
}