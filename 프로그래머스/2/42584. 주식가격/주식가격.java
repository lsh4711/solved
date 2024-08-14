import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer[]> stack = new ArrayDeque<>();
        int[] result = new int[prices.length];
        int idx = 0;
        
        while (idx < prices.length) {
            int price = prices[idx];
            while (!stack.isEmpty() 
                   && stack.getLast()[1] > price) {
                Integer[] priceInfo = stack.pollLast();
                result[priceInfo[0]] = idx - priceInfo[0];
            }
            if (stack.isEmpty() 
                || stack.getLast()[1] <= price) {
                stack.add(new Integer[] {idx, price});
            }
            idx++;
        }
        
        while (!stack.isEmpty()) {
            Integer[] priceInfo = stack.pop();
            result[priceInfo[0]] = idx - priceInfo[0] - 1;
        }
        
        return result;
    }
}