class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int idx = n - 1;
        int deliveryIdx = idx;
        int pickupIdx = idx;
        long totalDistance = 0;
        
        while (idx >= 0) {
            int delivery = deliveries[idx];
            int pickup = pickups[idx];
            if (delivery == 0 && pickup == 0) {
                idx--;
                continue;
            }
            totalDistance += (idx + 1) * 2;
            deliveryIdx = move(deliveries, deliveryIdx, cap);
            pickupIdx = move(pickups, pickupIdx, cap);
            idx = Math.max(deliveryIdx, pickupIdx);
        }
        
        return totalDistance;
    }
    
    private int move(int[] houses, int idx, int cap) {
        if (idx < 0) {
            return -1;
        }
        
        while (idx >= 0 && cap > 0) {
            int amount = houses[idx];
            if (amount <= cap) {
                cap -= amount;
                houses[idx--] = 0;
                continue;
            }
            houses[idx] -= cap;
            break;
        }
        
        return idx;
    }
}