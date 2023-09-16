package code.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13023 {
    static int global_count;
    static boolean check;
    static ArrayList<ArrayList<Integer>> friendsList = new ArrayList<>();

    public static void main(String[] arg ) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());


        //그래프 노드 추가(사람 수 만큼)
        for(int i=0; i<N; i++){
            friendsList.add(i,new ArrayList<Integer>());
        }

        //그래프 edge 추가(친구 관계 입력)
        for(int i=0; i<M; i++){

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            friendsList.get(a).add(b);
            friendsList.get(b).add(a);
        }

        for(int s=0; s<N ; s++){

            if(check){
                break;
            }
            boolean[] visited = new boolean[N];

            dfs(s,visited,1);

        }

        if(check){
            System.out.println(1);
        } else{
            System.out.println(0);
        }

    }
    static void dfs(int s,boolean[] visited,int depth){
        if(depth==5){
            check = true;
            return;
        }
        visited[s] = true;
        for(int t: friendsList.get(s)){
            if(!visited[t]){
                dfs(t,visited,depth+1);
            }
        }
        //반환작업을 해줘야함
        visited[s] = false;
    }
}
