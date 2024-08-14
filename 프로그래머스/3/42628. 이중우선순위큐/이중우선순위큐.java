import java.util.PriorityQueue;

class Solution {
    private PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    private PriorityQueue<Integer> pq2 = new PriorityQueue<>((i1, i2) -> i2 - i1);
    
    public int[] solution(String[] operations) {
        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];
            int value = Integer.parseInt(split[1]);
            if (command.equals("I")) {
                insert(value);
                continue;
            }
            if (value == -1) {
                deleteMin();
                continue;
            }
            if (value == 1) {
                deleteMax();
                continue;
            }
        }
        
        return isEmpty()
            ? new int[] {0, 0}
            : new int[] {pq2.peek(), pq1.peek()};
    }
    
    private void insert(int number) {
        pq1.add(number);
        pq2.add(number);
    }
    
    private void deleteMin() {
        if (isEmpty()) {
            return;
        }
        pq2.remove(pq1.poll());
    }
    
    private void deleteMax() {
        if (isEmpty()) {
            return;
        }
        pq1.remove(pq2.poll());
    }
    
    private boolean isEmpty() {
        return pq1.isEmpty() || pq2.isEmpty();
    }
}