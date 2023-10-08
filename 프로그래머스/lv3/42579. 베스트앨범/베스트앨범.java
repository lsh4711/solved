import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<int[]> datas = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (map.get(genre) == null) {
                map.put(genre, datas.size());
                datas.add(new int[] {0, 0, 0, 0, 0});
            }
            int idx = map.get(genre);
            add(datas.get(idx), i, play);
        }
        datas.sort((arr1, arr2) -> arr2[0] - arr1[0]);
        for (int[] data : datas) {
            results.add(data[1]);
            if (data[4] != 0) {
                results.add(data[3]);
            }
        }

        return results;
    }

    static void add(int[] values, int idx, int play) {
        values[0] += play;
        if (values[2] < play) {
            int tmpIdx = idx;
            int tmpPlay = play;
            idx = values[1];
            play = values[2];
            values[1] = tmpIdx;
            values[2] = tmpPlay;
        }
        if (values[4] < play) {
            values[3] = idx;
            values[4] = play;
        }

    }
}