import java.util.LinkedList;

class Solution {
    public int[] solution(String[] operations) {
        int[] result = new int[2];
        LinkedList<Integer> list = new LinkedList<>();

        for (String operation : operations) {
            char oper = operation.charAt(0);
            int num = Integer.parseInt(operation.substring(2, operation.length()));
            if (oper == 'I') {
                insert(list, num);
            } else if (list.size() == 0) {
                continue;
            } else if (num < 0) {
                list.remove(0);
            } else {
                list.remove(list.size() - 1);
            }
        }
        if (list.size() > 1) result = new int[] {list.get(list.size() - 1), list.get(0)};

        return result;
    }

    static void insert(LinkedList<Integer> list, int num) {
        if (list.size() == 0) {
            list.add(num);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) < num) continue;
            list.add(i, num);
            return;
        }

        list.add(num);
    }
}     