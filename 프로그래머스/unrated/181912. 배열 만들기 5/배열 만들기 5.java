import java.util.ArrayList;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (String intStr : intStrs) {
            intStr = intStr.substring(s, s + l);
            int num = Integer.parseInt(intStr);
            if (num > k) {
                list.add(num);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}