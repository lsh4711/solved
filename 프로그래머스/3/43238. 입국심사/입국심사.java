class Solution {
    public long solution(int n, int[] times) {
        long result = binarySearch(n, times);
        return result;
    }
    
    private long binarySearch(int n, int[] times) {
        long start = 1;
        long end = (long)1e18 + 1;
        
        while (start < end) {
            long mid = (start + end) / 2;
            long availablePersons = getAvailablePersons(n, times, mid);
            if (availablePersons < n) {
                start = mid + 1;
                continue;
            }
            if (availablePersons >= n) {
                end = mid;
                continue;
            }
        }
        
        return end;
    }
    
    private long getAvailablePersons(int n, int[] times, long maxTime) {
        long availablePersons = 0;
            
        for (int time : times) {
            availablePersons += (maxTime / time);
        }
        
        return availablePersons;
    }
}