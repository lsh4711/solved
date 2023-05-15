import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0; i < line.length - 1; i++) {
            int[] line1 = line[i];
            for(int j = i + 1; j < line.length; j++) {
                int[] line2 = line[j];
                long tmp1 = line1[0];
                long tmp2 = line2[0];
                long[] cross = new long[3];
                int[] copy = (line1[0] != 0) ? line1 : line2; // 0일수도 있음
                for(int k = 1; k < 3; k++) cross[k] = line1[k] * tmp2 - line2[k] * tmp1;
                if(cross[1] == 0) continue; // 평행할 때
                int x;
                int y;
                if(cross[2] % cross[1] != 0) continue; // 반대로도 나눠봐야함
                else y = (int)(cross[2] / -cross[1]);
                tmp1 = copy[2] + copy[1] * y;
                if(tmp1 % copy[0] != 0) continue;
                else x = (int)(tmp1 / -copy[0]);
                list.add(new int[] {x, y});
            }
        }
        int[] tmp = list.get(0);
        int[] x = {tmp[0], tmp[0]};
        int[] y = {tmp[1], tmp[1]};
        for(int[] arr : list) {
            if(arr[0] < x[0]) x[0] = arr[0];
            if(arr[0] > x[1]) x[1] = arr[0];
            if(arr[1] < y[0]) y[0] = arr[1];
            if(arr[1] > y[1]) y[1] = arr[1];
        }
        String[] result = new String[y[1] - y[0] + 1];
        int idx = 0;
        for(int i = y[1]; i >= y[0]; i--) {
            StringBuilder sb = new StringBuilder();
            label: for(int j = x[0]; j <= x[1]; j++) {
                for(int[] arr : list) {
                    if(arr[0] != j || arr[1] != i) continue;
                    sb.append('*');
                    continue label;
                }
                sb.append('.');
            }
            result[idx++] = sb.toString();
        }

        return result;
    }
}