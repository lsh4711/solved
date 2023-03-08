import java.util.ArrayList;

class Solution {
    public ArrayList solution(int n) {
        ArrayList<Integer> list = new ArrayList();
        
        for(int i=1; i<=(n/2); i++) {
            if(n%i == 0) list.add(i);
        }
        list.add(n);
        
        return list;
    }
}