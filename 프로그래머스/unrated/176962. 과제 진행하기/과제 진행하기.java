import java.util.*;

class Solution {
    public ArrayList<String> solution(String[][] plans) {
        Stack<int[]> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        int[][] plansCopy = new int[plans.length][];
        
        for(int i = 0; i < plans.length; i++) {
            String[] hm = plans[i][1].split(":");
            int minute = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            plansCopy[i] = new int[] {i, minute, Integer.parseInt(plans[i][2])};
        }
        Arrays.sort(plansCopy, (arr1, arr2) -> arr1[1] - arr2[1]);
        stack.push(plansCopy[0]);
        for(int i = 1; i < plansCopy.length; i++) {
            int[] nextPlan = plansCopy[i];
            int remain = nextPlan[1] - stack.peek()[1];
            while(remain > 0 && !stack.isEmpty()) {
                int[] nowPlan = stack.pop();
                int nowPlaytime = nowPlan[2];
                if(nowPlan[2] <= remain) list.add(plans[nowPlan[0]][0]);
                else {
                    nowPlan[1] = nextPlan[1];
                    nowPlan[2] -= remain;
                    stack.push(nowPlan);
                }
                remain -= nowPlaytime;
            }
            stack.push(nextPlan);
        }
        while(!stack.isEmpty()) list.add(plans[stack.pop()[0]][0]);

        return list;
    }
}  