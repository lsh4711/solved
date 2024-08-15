import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int[] distances = new int[rocks.length + 1];
        
        Arrays.sort(rocks);
        
        int previousPoint = 0;
        
        for (int i = 0; i < rocks.length; i++) {
            int rock = rocks[i];
            distances[i] = rock - previousPoint;
            previousPoint = rock;
        }
        
        distances[distances.length - 1] = distance - rocks[rocks.length - 1];
        
        int result = binarySearch(distance, rocks, n, distances);
        
        return result;
    }
    
    private int binarySearch(int distance, int[] rocks, int n, int[] distances) {
        int start = 0;
        int end = distance + 1;
        
        while (start < end) {
            int mid = (start + end) / 2;
            if (isValidMinimumDistance(n, distances, mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start - 1;
    }
    
    private boolean isValidMinimumDistance(int n, int[] distances, int minDistance) {
        int temp = 0;
        
        for (int distance : distances) {
            distance += temp;
            if (distance >= minDistance) {
                temp = 0;
                continue;
            }
            if (n-- == 0) {
                return false;
            }
            temp = distance;
        }
        
        return true;
    }
}