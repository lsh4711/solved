import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            boolean bool = flag[i];
            if (bool) {
                addRepeatedly(list, num);
            } else {
                removeRepeatedly(list, num);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
    
    static void addRepeatedly(ArrayList<Integer> list, int num) {
        int cnt = num * 2;
        
        while (cnt-- > 0) {
            list.add(num);
        }

    }
    
    static void removeRepeatedly(ArrayList<Integer> list, int num) {
        while (num-- > 0) {
            list.remove(list.size() - 1);
        }

    }
}