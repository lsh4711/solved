import java.util.*;

class Solution {
    // public String[] solution(String[][] plans) {
    public ArrayList<String> solution(String[][] plans) {
        // String[] answer = new String[plans.length];
        ArrayList<String> list = new ArrayList<>();
        Stack<String[]> stack = new Stack<>();

        for(String[] plan : plans) {
            String[] time = plan[1].split(":");
            plan[1] = Integer.toString(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
        }
        Arrays.sort(plans, (arr1, arr2) -> Integer.parseInt(arr1[1]) - Integer.parseInt(arr2[1]));
        for(int i = 0; i < plans.length; i++) {
            String[] plan = plans[i];
            if(stack.isEmpty()) {
                stack.push(plan);
                continue;
            }
            String[] prevPlan = stack.peek();
            int[] prev = {Integer.parseInt(prevPlan[1]), Integer.parseInt(prevPlan[2])};
            int[] now = {Integer.parseInt(plan[1]), Integer.parseInt(plan[2])};
            int remain = now[0] - prev[0];
            if(prev[1] > remain) {
                prevPlan[1] = Integer.toString(now[0]);
                prevPlan[2] = Integer.toString(prev[1] - remain);
                stack.push(plan); 
                continue;
            }
            while(remain > 0 && !stack.isEmpty()) {
                prevPlan = stack.pop();
                prev[1] = Integer.parseInt(prevPlan[2]);
                if(prev[1] <= remain) list.add(prevPlan[0]);
                else {
                    prevPlan[1] = Integer.toString(now[0]);
                    prevPlan[2] = Integer.toString(prev[1] - remain);
                    stack.push(prevPlan);
                }
                remain -= prev[1];
            }
            stack.push(plan);
        }
        while(!stack.isEmpty()) list.add(stack.pop()[0]);

        // return answer;
        return list;
    }
}  