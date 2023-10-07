import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (arr1, arr2) -> arr1[0] - arr2[0]);
        int cnt = 1;
        int outPoint = routes[0][1];
        
        for (int i = 1; i < routes.length; i++) {
            int[] nextRoute = routes[i];
            if (outPoint < nextRoute[0]) {
                outPoint = nextRoute[1];
                cnt++;
                continue;
            }
            if (outPoint > nextRoute[1]) {
                outPoint = nextRoute[1];
            }
        }
     
        return cnt;
    }
} 