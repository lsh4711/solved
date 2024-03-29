import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    private final HashSet<String> set = new HashSet<>();
    
    public int solution(String[][] relation) {
        int totalCandidateKeyCount = 0;
        
        for (int maxSize = 1; maxSize <= relation[0].length; maxSize++) {
            totalCandidateKeyCount += countCandidateKey(relation, maxSize, new ArrayList<>(), 0);
        }
        
        return totalCandidateKeyCount;
    }
    
    private int countCandidateKey(String[][] relation, int maxSize, ArrayList<Integer> columnIndexes, int idx)  {
        if (columnIndexes.size() == maxSize) {
            if (!isCandidateKey(relation, columnIndexes)) {
                return 0;
            }
            set.add(columnIndexes.toString());
            return 1;
        }
        
        int cnt = 0;
        
        for (int col = idx; col < relation[0].length; col++) {
            ArrayList<Integer> nextColumnIndexes = new ArrayList<>(columnIndexes);
            nextColumnIndexes.add(col);
            cnt += countCandidateKey(relation, maxSize, nextColumnIndexes, col + 1);
        }
            
        return cnt;
    }
    
    private boolean isCandidateKey(String[][] relation, ArrayList<Integer> columnIndexes) {
        return isUnique(relation, columnIndexes) && !hasCandidateKey(columnIndexes, new ArrayList<>(), 0);
    }
    
    private boolean isUnique(String[][] relation, ArrayList<Integer> columnIndexes) {
        StringBuilder sb = new StringBuilder();
        HashSet<String> tempSet = new HashSet<>();
        
        for (String[] row : relation) {
            for (int columnIndex : columnIndexes) {
                sb.append(row[columnIndex]);
            }
            if (!tempSet.add(sb.toString())) {
                return false;
            }
            sb.setLength(0);
        }
        
        return true;
    }
    
    private boolean hasCandidateKey(ArrayList<Integer> baseColumnIndexes, ArrayList<Integer> columnIndexes, int currentIdx) {
        if (set.contains(columnIndexes.toString())) {
            return true;
        }
        
        for (int idx = currentIdx; idx < baseColumnIndexes.size(); idx++) {
            int columnIndex = baseColumnIndexes.get(idx);
            ArrayList<Integer> nextColumnIndexes = new ArrayList<>(columnIndexes);
            nextColumnIndexes.add(columnIndex);
            if (hasCandidateKey(baseColumnIndexes, nextColumnIndexes, idx + 1)) {
                return true;
            }
        }
        
        return false;
    }
}