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
        initGraphsAndCounts(edges);
        rootNum = getRootNum();
        visitGraphs(nodes[rootNum]);
        
        return new int[] {rootNum, donutCount, stickCount, roopCount};
    }
    
    private void initGraphsAndCounts(int[][] edges) {
        for (int[] edge : edges) {
            int startNum = edge[0];
            int destNum = edge[1];
            startCounts[startNum]++;
            visitCounts[destNum]++;
            if (nodes[startNum] == null) {
                nodes[startNum] = new ArrayList<>();
            }
            nodes[startNum].add(destNum);
        }
        
    }
    
    private int getRootNum() {
        int currentNum = 1;
        
        while (startCounts[currentNum] < 2 || visitCounts[currentNum] > 0) {
            currentNum++;
        }
        
        return currentNum;
    }
    
    private void visitGraphs(ArrayList<Integer> rootNode) {
        for (int num : rootNode) {
            visitGraph(num, nodes);
        }
        
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
        visitRecursive(startNum, nodes[currentNum].get(0), nodes);
    }
}