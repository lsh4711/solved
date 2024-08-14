import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> waitingQueue = new LinkedList<>();
        Deque<Integer> bridgeQueue = new LinkedList<>();
        int weights = 0;
        int runningTrucks = 0;
        int time = 0;
        
        for (int truckWeight : truck_weights) {
            waitingQueue.add(truckWeight);
        }
        
        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.add(null);
        }
        
        while (!waitingQueue.isEmpty() || !bridgeQueue.isEmpty()) {
            time++;
            Integer arrivedTruck = bridgeQueue.pollFirst();
            if (arrivedTruck != null) {
                weights -= arrivedTruck;
                runningTrucks--;
            }
            if (runningTrucks < bridge_length
                && !waitingQueue.isEmpty()
                && waitingQueue.getFirst() + weights <= weight) {
                int truck = waitingQueue.removeFirst();
                bridgeQueue.add(truck);
                weights += truck;
                runningTrucks++;
            } else {
                bridgeQueue.add(null);
            }
            if (runningTrucks == 0 && waitingQueue.isEmpty()) {
                return time;
            }
        }
        
        return time;
    }
}