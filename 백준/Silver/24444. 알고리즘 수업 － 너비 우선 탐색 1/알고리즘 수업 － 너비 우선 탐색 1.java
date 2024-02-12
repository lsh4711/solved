import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> list;

    public static void bfs(int r){
        Queue<Integer> q = new LinkedList<>();
        q.offer(r);
        int cnt = 1;
        ch[r] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            Collections.sort(list.get(cur));

            for(int i : list.get(cur)){
                if(ch[i] == 0){
                    cnt++;
                    ch[i] = cnt;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        ch = new int[n+1];
        list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++){
            String line = br.readLine();
            String[] split = line.split(" ");

            int n1 = Integer.parseInt(split[0]);
            int n2 = Integer.parseInt(split[1]);

            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        bfs(r);
        
        for(int i = 1; i <= n; i++){
            sb.append(ch[i]).append('\n');
        }
        
        System.out.println(sb);
    }
}