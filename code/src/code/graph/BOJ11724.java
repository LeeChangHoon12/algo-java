package code.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//연결 요소의 개수
public class BOJ11724 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] arg ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N+1;i++){
            graph.add(i,new ArrayList<Integer>());
        }

        for(int i=0;i<M;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        check = new boolean[N+1];
        int count = 0;
        Arrays.fill(check, false);
        check[0] = true;

        for(int i=0;i<check.length;i++){
            if(!check[i]){
                count++;
                dfs(check,i);
            }
        }

        System.out.print(count);

    }

    static void dfs(boolean[] check,int u){

        check[u] = true;
        for(int t: graph.get(u)){
            if(!check[t]){
                dfs(check,t);
            }
        }

    }
}
