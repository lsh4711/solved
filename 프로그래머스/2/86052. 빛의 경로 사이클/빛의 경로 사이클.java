import java.util.ArrayList;

class Solution {
    private static final int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private Node[][] board;
    private final ArrayList<Integer> result = new ArrayList<>();
    
    private Node node = null;
    private int outputDirectionIndex = -1;
    
    public int[] solution(String[] grid) {
        init(grid);
        
        for (Node[] nodes : board) {
            for (Node node : nodes) {
                go(node);
            }
        }
        
        result.sort(null);

        return result.stream().mapToInt(i -> i).toArray();
    }

    private void init(String[] grid) {
        board = new Node[grid.length][grid[0].length()];

        for (int row = 0; row < grid.length; row++) {
            String line = grid[row];
            for (int col = 0; col < line.length(); col++) {
                char direction = line.charAt(col);
                int[] outputs = {0, 0, 0, 0};
                board[row][col] = new Node(direction, outputs);
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col].nextNodes = getNextNodes(row, col);
            }
        }

    }

    private Node[] getNextNodes(int row, int col) {
        Node[] nodes = new Node[4];

        for (int directionIdx = 0; directionIdx < moves.length; directionIdx++) {
            int[] coordinate = getNextCoordinate(row, col, moves[directionIdx]);
            nodes[directionIdx] = board[coordinate[0]][coordinate[1]];
        }

        return nodes;
    }

    private int[] getNextCoordinate(int row, int col, int[] move) {
        row = (row + move[0] + board.length) % board.length;
        col = (col + move[1] + board[0].length) % board[0].length;
        return new int[]{row, col};
    }

    private void go(Node startNode) {
        for (int directionIdx = 0; directionIdx < moves.length; directionIdx++) {
            int distance = 0;
            node = startNode;
            outputDirectionIndex = directionIdx;
            while (node != null) {
                distance += goNextNode();
            }
            if (distance > 0) {
                result.add(distance);
            }
        }

    }

    private int goNextNode() {
        if (!node.hasNewRoute(outputDirectionIndex)) {
            node = null;
            outputDirectionIndex = -1;
            return 0;
        }

        node.outputs[outputDirectionIndex]++;
        node = node.getNextNode(outputDirectionIndex);
        int offset = node.direction == 'L' ? 1
                : node.direction == 'R' ? 3
                : 2;
        outputDirectionIndex = (outputDirectionIndex + offset + 2) % 4;

        return 1;
    }

    private static class Node {
        public char direction;
        public int[] outputs;
        public Node[] nextNodes = new Node[4];

        public Node(char direction, int[] outputs) {
            this.direction = direction;
            this.outputs = outputs;
        }

        public boolean hasNewRoute(int outputDirectionIdx) {
            return outputs[outputDirectionIdx] == 0;
        }

        public Node getNextNode(int outputDirectionIdx) {
            return nextNodes[outputDirectionIdx];
        }

    }
}