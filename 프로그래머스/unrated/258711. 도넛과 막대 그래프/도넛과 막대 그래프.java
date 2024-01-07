import java.util.ArrayList;

class Solution {
    private int rootNum;
    private int donutCount;
    private int stickCount;
    private int roopCount;
    
    private static final int MAX = 1000001;
    
    private int[] startCounts = new int[MAX];
    private int[] visitCounts = new int[MAX];
    private ArrayList<Integer>[] nodes = new ArrayList[MAX];
    
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
        for (int dest : rootNode) {
            visitGraphRecursively(dest, nodes[dest]);
        }
        
    }
    
    private void visitGraphRecursively(int startNum, ArrayList<Integer> currentNode) {
        int currentNum;
        
        if (currentNode != null) {
            currentNum = currentNode.get(0);
        } else {
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
        visitGraphRecursively(startNum, nodes[currentNum]);
    }
}