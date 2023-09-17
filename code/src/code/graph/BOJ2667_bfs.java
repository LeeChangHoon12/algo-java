package code.graph;

import java.awt.*;
import java.io.*;
import java.util.*;

public class BOJ2667_bfs {

    static boolean visit[][];
    static Queue<Point> queue = new LinkedList<>();

    static int arr[][];
    static ArrayList<Integer> count_list;
    static int number;
    static int count;

    static int nowX = 0;
    static int nowY = 0;

    static int N;


    //상, 하, 좌, 우
    static int dirX[] = {0,0,-1,1};
    static int dirY[] = {1,-1,0,0};


    public static void main(String[] arg ) throws IOException {

        //N입력
        //N*N 좌표 입력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visit = new boolean[N][N];


        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N ; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        count_list = new ArrayList<Integer>();

        for(int i=0;i<N;i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j] && arr[i][j] == 1){
                    count = 1;
                    bfs(i,j);
                    count_list.add(count);
                }
            }
        }

        Collections.sort(count_list);

        bw.write(count_list.size() + "\n");
        for(int count: count_list){
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();

    }

    static void bfs(int x, int y){
        visit[x][y] = true;
        queue.add(new Point(x,y));

        while (!queue.isEmpty()){

            Point p = queue.poll();

            for(int i=0; i<4; i++){
                nowX = p.x+ dirX[i];
                nowY = p.y + dirY[i];

                if(checkOutOfRange() && !visit[nowX][nowY] && arr[nowX][nowY] == 1){
                    queue.add(new Point(nowX,nowY));
                    visit[nowX][nowY] = true;
                    count++;
                }
            }
        }
    }

    static boolean checkOutOfRange(){
        return(nowX >=0 && nowX < N && nowY >= 0 && nowY < N);
    }
}
