package code.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707 {
    public static void main(String[] arg ) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<ArrayList<ArrayList<Integer>>> testCase = new ArrayList<>();

        int k = Integer.parseInt(st.nextToken());
        for(int i=0; i<k; i++){

            //테스트 케이스에 n번째 그래프 추가
            testCase.add(i,new ArrayList<ArrayList<Integer>>());

            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            for(int node=0; node<v+1; node++){
                testCase.get(i).add(node,new ArrayList<Integer>());
            }

            for(int j=0; j<u; j++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                testCase.get(i).get(a).add(b);
                testCase.get(i).get(b).add(a);

            }

            boolean result = true;
            boolean[] visited = new boolean[v+1];

            for(int start=1; start<v+1; start++){
                if(!visited[start]){
                    if(!isBiGraph(testCase.get(i),start,visited)){
                        result = false;
                        break;
                    }
                }

            }

            if(result){
                System.out.print("YES");
            }else{
                System.out.print("NO");
            }
            System.out.println();
        }
    }

    //넓이 우선 탐색
    static boolean isBiGraph(ArrayList<ArrayList<Integer>> graph, int start,boolean[] visited){

        int [] team = new int[graph.size()];
        boolean check = true;


        Queue<Integer> queue = new LinkedList<Integer>();

        visited[start] = true;
        queue.add(start);
        team[start] = -1;

        while(!queue.isEmpty()){
            int next = queue.poll();

            for(int t: graph.get(next)){

                if(!visited[t]){
                    team[t] = team[next] * -1;
                    visited[t] = true;
                    queue.add(t);
                } else{
                    if(team[t] == team[next]){
                        check = false;
                        return check;
                    }
                }

            }
        }

        return check;
    }
}
