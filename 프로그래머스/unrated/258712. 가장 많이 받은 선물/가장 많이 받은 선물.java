import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    private int result;
    private int[] giftCounts;
    private int[][] sheet;
    private HashMap<String, Integer> scoreMap = new HashMap<>();
    private HashMap<String, Integer> indexMap = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {    
        giftCounts = new int[friends.length];
        sheet = new int[friends.length][friends.length];
        
        int cnt = 0;
        
        for (String friend : friends) {
            scoreMap.put(friend, 0);
            indexMap.put(friend, cnt++);
        }
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String sender = split[0];
            String reciever = split[1];
            int senderIdx = indexMap.get(sender);
            int recieveridx = indexMap.get(reciever);
            
            sheet[senderIdx][recieveridx]++;
            scoreMap.put(sender, scoreMap.get(sender) + 1);
            scoreMap.put(reciever, scoreMap.get(reciever) - 1);
        }
        run(friends, 0);
        for (int giftCount : giftCounts) {
            if (giftCount > result) {
                result = giftCount;
            }
        }
        
        return result;
    }
    
    private void run(String[] friends, int idx) {
        if (idx >= friends.length) {
            return;
        }
        
        String sender = friends[idx];
        int senderIdx = indexMap.get(sender);
        
        for (int i = idx + 1; i < friends.length; i++) {
            String reciever = friends[i];
            int recieverIdx = indexMap.get(reciever);
            
            int senderToRecieverCount = sheet[senderIdx][recieverIdx];
            int recieverToSenderCount = sheet[recieverIdx][senderIdx];
            
            if (senderToRecieverCount == recieverToSenderCount) {
                int senderGiftScore = scoreMap.get(sender);
                int recieverGiftScore = scoreMap.get(reciever);
                if (senderGiftScore > recieverGiftScore) {
                    giftCounts[senderIdx]++;
                } else if (senderGiftScore < recieverGiftScore) {
                    giftCounts[recieverIdx]++;
                }                
                continue;
            }
            if (senderToRecieverCount > recieverToSenderCount) {
                giftCounts[senderIdx]++;
            } else {
                giftCounts[recieverIdx]++;
            }
        }
        run(friends, idx + 1);
    }
}