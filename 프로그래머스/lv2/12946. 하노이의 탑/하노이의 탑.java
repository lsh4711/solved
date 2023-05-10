import java.util.*;

class Solution {
    public ArrayList<int[]> solution(int n) {
        int one = (n % 2 == 0) ? 2 : 3;
        boolean moveOne = false;
        ArrayList<int[]> result = new ArrayList<>();
        Stack<Integer>[] stacks = new Stack[4];
        
        for(int i = 1; i < 4; i++) stacks[i] = new Stack<>();
        for(int i = n; i > 1; i--) stacks[1].push(i);
        stacks[one].push(1);
        result.add(new int[] {1, one});
        
        while(stacks[3].size() < n) {
            int now = one;
            int go = -1;
            int circle = 1;
            if(moveOne) {
                for(int i = 1; i < 4; i++) {
                    if(i == one || !stacks[i].isEmpty() && stacks[i].peek() % 2 != 0) continue;
                    if(go == -1) go = i;
                    else if(stacks[go].isEmpty() || !stacks[i].isEmpty() && stacks[go].peek() < stacks[i].peek()) go = i;
                }
                stacks[one].pop();
                one = go;
            } else {
                for(int i = 1; i < 4; i++) {
                    if(i == one) continue;
                    if(now == one) now = i;
                    else go = i;
                }
                if(stacks[now].isEmpty() || !stacks[go].isEmpty() && stacks[now].peek() > stacks[go].peek()) {
                    int temp = now;
                    now = go;
                    go = temp;
                }
                circle = stacks[now].pop();
            }
            moveOne = !moveOne;
            result.add(new int[] {now, go});
            stacks[go].push(circle);
        }
        
        return result;
    }
}