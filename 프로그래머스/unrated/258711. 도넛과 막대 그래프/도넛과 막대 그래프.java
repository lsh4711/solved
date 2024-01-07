import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private int rootNum;
    private int donutCount;
    private int stickCount;
    private int roopCount;
    
    private int[] startCounts;
    private int[] visitCounts;
    
    public int[] solution(int[][] edges) {
        int maxNodeNum = 0;
        
        for (int[] edge : edges) {
            int startNum = edge[0];
            int destNum = edge[1];
            int max = startNum > destNum ? startNum : destNum;
            if (max > maxNodeNum) {
                maxNodeNum = max;
            }
        }
        
        startCounts = new int[maxNodeNum + 1];
        visitCounts = new int[maxNodeNum + 1];
        
        ArrayList<Integer>[] nodes = new ArrayList[maxNodeNum + 1];
        
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int startNum = edge[0];
            int destNum = edge[1];
            startCounts[startNum]++;
            visitCounts[destNum]++;
        }
        
        for (int i = 1; i < visitCounts.length; i++) {
            int startCount = startCounts[i];
            int visitCount = visitCounts[i];
            if (startCount > 1 && visitCount == 0) {                
                rootNum = i;
                break;
            }
        }
        
        for (int[] edge : edges) {
            int startNum = edge[0];
            int destNum = edge[1];
            ArrayList<Integer> startNode = nodes[startNum];
            startNode.add(destNum);
        }
        
        ArrayList<Integer> rootNode = nodes[rootNum];
        
        for (int num : rootNode) {
            visitGraph(num, nodes);
        }
        
        return new int[] {rootNum, donutCount, stickCount, roopCount};
    }
    
    private void visitGraph(int currentNum, ArrayList<Integer>[] nodes) {
        if (startCounts[currentNum] == 1 && visitCounts[currentNum] == 1
           || startCounts[currentNum] == 0
           || visitRecursive(currentNum, nodes[currentNum].get(0), nodes)) {
            stickCount++;
        }
        
    }
    
    private boolean visitRecursive(int startNum, int currentNum, ArrayList<Integer>[] nodes) {
        if (startCounts[currentNum] == 2) {
            roopCount++;
            return false;
        }
        if (startNum == currentNum) {
            donutCount++;
            return false;
        }
        
        ArrayList<Integer> currentNode = nodes[currentNum];
        
        for (int destNum : currentNode) {
            if (visitRecursive(startNum, destNum, nodes)) {
                continue;
            }
            return false;
        }
        
        return true;
    }
}