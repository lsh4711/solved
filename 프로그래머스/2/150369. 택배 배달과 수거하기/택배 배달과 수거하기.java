import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    private int count = 0;
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Deque<int[]> deliveryStack = new ArrayDeque<>();
        Deque<int[]> pickupStack = new ArrayDeque<>();
        long totalDistance = 0;
        
        for (int i = 0; i < n; i++) {
            int delivery = deliveries[i];
            int pickup = pickups[i];
            if (delivery != 0) {
                deliveryStack.add(new int[] {i, delivery});
            }
            if (pickup != 0) {
                pickupStack.add(new int[] {i, pickup});
            }
        }
        
        while(!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
            int[] deliveryInfo = deliveryStack.peekLast();
            int[] pickupInfo = pickupStack.peekLast();
            int furthestIdx = getFurthestHounseIndex(deliveryInfo, pickupInfo);
            totalDistance += (furthestIdx + 1) * 2;
            process(deliveryStack, cap);
            process(pickupStack, cap);
        }
        
        return totalDistance;
    }

    private int getFurthestHounseIndex(int[] deliveryInfo, int[] pickupInfo) {
        if (deliveryInfo == null) {
            return pickupInfo[0];
        }
        
        if (pickupInfo == null) {
            return deliveryInfo[0];
        }
        return Math.max(deliveryInfo[0], pickupInfo[0]);
    }
    
    private void process(Deque<int[]> stack, int cap) {
        while (!stack.isEmpty() && cap > 0) {
            int[] info = stack.peekLast();
            if (info[1] > cap) {
                info[1] -= cap;
                break;
            }
            cap -= info[1];
            stack.removeLast();
        }
    }
    
}
