import java.util.ArrayList;

class Solution {
    private ArrayList<Integer> graph = new ArrayList<>();
    private ArrayList<Double> areas = new ArrayList<>();
    
    public double[] solution(int k, int[][] ranges) {
        double[] result = new double[ranges.length];
        int idx = 0;
        
        initGraphAndAreas(k);
        
        for (int[] range : ranges) {
            result[idx++] = di(range);
        }
        
        return result;
    }
    
    private void initGraphAndAreas(int k)  {
        int y = k;
        
        while (k > 1) {
            graph.add(k);
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            areas.add(y + (k - y) / 2.0);
            y = k;
        }
        
        graph.add(k);
    }
    
    private double di(int[] range) {
        int[] xRange = {range[0], areas.size() + range[1]};
        
        if (xRange[0] == xRange[1]) {
            return 0;
        }
        if (xRange[0] > xRange[1]) {
            return -1;
        }
        
        return getAreaInRange(xRange[0], xRange[1]);
    }
    
    private double getAreaInRange(int start, int end) {
        double areaSum = 0;
        
        while (start < end) {
            areaSum += areas.get(start++);
        }
            
        return areaSum;
    }
}
