import java.util.ArrayList;

class Solution {
    public String[] solution(String myString) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : myString.toCharArray()) {
            if (c != 'x') {
                sb.append(c);
            } else if (sb.length() > 0) {
                list.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        list.sort(null);
        
        return list.toArray(new String[0]);
    }
}