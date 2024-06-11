import java.util.PriorityQueue;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (String time : timetable) {
            int minutes = timeToMinutes(time);
            pq.add(minutes);
        }
        
        int busTime = timeToMinutes("09:00") - t;
        int lastCrewTime = 0;
        int remain = 0;
        
        while (n > 0) {
            busTime += t;
            remain = m;
            
            while (!pq.isEmpty() && remain > 0 && pq.peek() <= busTime) {
                lastCrewTime = pq.poll();
                remain--;
            }
            
            n--;
        }
        
        if (remain > 0) {
            return minutesToTime(busTime);
        }
        return minutesToTime(lastCrewTime - 1);
    }
    
    private int timeToMinutes(String time) {
        String[] split = time.split(":");
        
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    private String minutesToTime(int minutes) {
        int hour = minutes / 60;
        minutes %= 60;
        
        return String.format("%02d:%02d", hour, minutes);
    }
}