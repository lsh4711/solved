import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        
        for (String phone : phone_book) {
            set.add(phone);
        }
        
        for (String phone : phone_book) {
            String parts = "";
            char[] literals = phone.toCharArray();
            for (int i = 0; i < literals.length - 1; i++) {
                parts += literals[i];
                if (set.contains(parts)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}