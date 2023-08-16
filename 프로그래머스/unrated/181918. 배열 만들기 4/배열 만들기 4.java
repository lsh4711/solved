import java.util.Stack;

class Solution {
    public Stack<Integer> solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length;) {
            if (stack.isEmpty()) {
                stack.push(arr[i++]);
            } else if (stack.peek() < arr[i]) {
                stack.push(arr[i++]);
            } else {
                stack.pop();
            }
        }
        
        return stack;
    }
}