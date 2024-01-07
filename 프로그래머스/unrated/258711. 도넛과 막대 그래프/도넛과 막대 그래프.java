import java.util.ArrayList;

class Solution {
    private int rootNum;
    private int donutCount;
    private int stickCount;
    private int roopCount;
    
    private int[] startCounts = new int[1000001];
    private int[] visitCounts = new int[1000001];
    
    private ArrayList<Integer>[] nodes = new ArrayList[1000001];
    
    public int[] solution(int[][] edges) {
        for (int[] edge : edges) {
            int startNum = edge[0];
            int destNum = edge[1];
            
            startCounts[startNum]++;
            visitCounts[destNum]++;
            
            if (nodes[startNum] == null) {
                nodes[startNum] = new ArrayList<>();
            }
            ArrayList<Integer> startNode = nodes[startNum];
            startNode.add(destNum);
        }
        for (int i = 1; i < visitCounts.length; i++) {
            int startCount = startCounts[i];
            int visitCount = visitCounts[i];
            if (startCount > 1 && visitCount == 0) {
                rootNum = i;
                break;
            }
        }
        
        ArrayList<Integer> rootNode = nodes[rootNum];
        
        for (int num : rootNode) {
            visitGraph(num, nodes);
        }
        
        return new int[] {rootNum, donutCount, stickCount, roopCount};
    }
    
    private void visitGraph(int currentNum, ArrayList<Integer>[] nodes) {
        if (startCounts[currentNum] == 0
           || startCounts[currentNum] == 1 && visitCounts[currentNum] == 1) {
            stickCount++;
            return;
        }
        if (startCounts[currentNum] == 2) {
            roopCount++;
            return;
        }
        visitRecursive(currentNum, nodes[currentNum].get(0), nodes);
    }
    
    private void visitRecursive(int startNum, int currentNum, ArrayList<Integer>[] nodes) {
        if (startCounts[currentNum] == 0) {
            stickCount++;
            return;
        }
        if (startCounts[currentNum] == 2) {
            roopCount++;
            return;
        }
        if (startNum == currentNum) {
            donutCount++;
            return;
        }
        
        ArrayList<Integer> currentNode = nodes[currentNum];
        
        visitRecursive(startNum, currentNode.get(0), nodes);
    }
}