import java.util.ArrayList;

class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> list = new ArrayList<>();
        
        for (String str : strArr) {
            int idx = str.indexOf("ad");
            if (idx == -1) {
                list.add(str);
            }
        }
        
        return list.toArray(new String[0]);
    }
}