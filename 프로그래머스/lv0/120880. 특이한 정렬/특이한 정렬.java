import java.util.*;

class Solution {
    public Integer[] solution(int[] numlist, int n) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i : numlist) list.add(Math.abs(i-n));
        Integer[] arr = list.toArray(new Integer[0]);
        Arrays.sort(arr);
        for(int i=0; i<numlist.length; i++) {
            int io = list.indexOf(arr[i]);
            int lio = list.lastIndexOf(arr[i]);
            if(numlist[io] == numlist[lio]) arr[i] = numlist[io];
            else {
                arr[i] = Math.max(numlist[io], numlist[lio]);
                arr[i+1] = Math.min(numlist[io], numlist[lio]);
                i++;
            }
        }

        return arr;
    }
}