class Solution {
    static int[][] array;
    static void setArray(int [][] set) {
        array = set;
    }
    
    public int solution(int[][] dots) {
        int answer = 0;
        setArray(dots);
        
        if(cal(0, 1) == cal(2, 3)) return 1;
        if(cal(0, 2) == cal(1, 3)) return 1;
        if(cal(0, 3) == cal(1, 2)) return 1;
        return 0;
        }
    
    static double cal(int c1, int c2) {
        int x = (array[c1][0]-array[c2][0]);
        int y = (array[c1][1]-array[c2][1]);
        
        return (double) y / x;
    }
}