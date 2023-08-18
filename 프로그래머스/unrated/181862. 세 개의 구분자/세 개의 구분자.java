import java.util.ArrayList;

class Solution {
    public ArrayList<String> solution(String myStr) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : myStr.toCharArray()) {
            if (c != 'a' && c != 'b' && c != 'c') {
                sb.append(c);
            } else if (sb.length() > 0) {
                list.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        } else if (list.size() == 0) {
            list.add("EMPTY");
        }
        
        return list;
    }
}