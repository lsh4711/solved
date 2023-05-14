import java.util.LinkedList;

class Solution {
    public LinkedList<Integer> solution(int[] arr, int[] query) {
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i : arr) list.add(i);
        for(int i = 0; i < query.length; i++) {
            int idx = query[i];
            if(i % 2 == 0) {
                while(list.size() > idx + 1) list.remove(list.size() - 1);
            } else {
                while(idx-- > 0) list.remove(0);
            }
        }
        
        return list;
    }
}