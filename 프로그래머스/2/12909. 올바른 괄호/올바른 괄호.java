import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        char[] literals = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char literal : literals) {
            if (stack.isEmpty() || stack.peekLast() == literal) {
                stack.push(literal);
                continue;
            }
            if (stack.peekLast() == ')') {
                return false;
            }
            stack.pollLast();
        }
        
        return stack.isEmpty();
    }
}