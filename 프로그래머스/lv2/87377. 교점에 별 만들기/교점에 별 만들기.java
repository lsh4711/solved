import java.util.ArrayList;

class Solution {
    static ArrayList<int[]> list = new ArrayList<>();
    public String[] solution(int[][] line) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int[] xRange = {max, min};
        int[] yRange = {max, min};

        for(int i = 0; i < line.length - 1; i++) {
            long[] line1 = {line[i][0], line[i][1], line[i][2]};
            for(int j = i + 1; j < line.length; j++) {
                int[] line2 = line[j];
                long denom = line1[0] * line2[1] - line1[1] * line2[0];
                long xNum = line1[1] * line2[2] - line1[2] * line2[1];
                long yNum = line1[2] * line2[0] - line1[0] * line2[2];
                if(denom == 0 || xNum % denom != 0 || yNum % denom != 0) continue;
                int x = (int)(xNum / denom);
                int y = (int)(yNum / denom);
                if(xRange[0] > x) xRange[0] = x;
                if(xRange[1] < x) xRange[1] = x;
                if(yRange[0] > y) yRange[0] = y;
                if(yRange[1] < y) yRange[1] = y;
                list.add(new int[] {x, y});
            }
        }
        boolean[][] coorPlane = new boolean[yRange[1] - yRange[0] + 1][xRange[1] - xRange[0] + 1];
        String[] result = new String[coorPlane.length];
        
        for(int[] xy : list) {
            int xCal = xy[0] - xRange[0];
            int yCal = coorPlane.length - (xy[1] - yRange[0] + 1);
            coorPlane[yCal][xCal] = true;
        }
        for(int i = 0; i < coorPlane.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < coorPlane[0].length; j++) {
                if(coorPlane[i][j]) sb.append('*');
                else sb.append('.');
            }
            result[i] = sb.toString();
        }

        return result;
    }
}