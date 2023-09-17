package code.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2667_dfs {

    static int arr[][];
    static boolean visited[][];
    static int dirX[] = {0,0,-1,1}; //좌,우 확인
    static int dirY[] = {-1,1,0,0}; //상,하 확인

    static int count = 0;
    static int number = 0;
    static int nowX, nowY, N;
    public static void main(String[] arg ) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> count_list = new ArrayList<>();

        /*입력 예시*/
        /*

        7
        0110100
        0110101
        1110101
        0000111
        0100000
        0111110
        0111000

        */

        // N 개수 입력 받고
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        // N*N 배열에 0,1 입력 받기
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        //좌표 마다 반복하면서 상하좌우 dfs해서 visited 체크 및 numbering 해줌
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && arr[i][j]==1 ){
                    count = 0;
                    number++;
                    dfs(i,j);

                    count_list.add(count);

                }
            }
        }

        Collections.sort(count_list);
        bw.append(number + "\n");

        for(int i: count_list){
            bw.append(i + "\n");
        }

        bw.flush();
        bw.close();


    }

    static void dfs(int x,int y){
        visited[x][y] = true;
        arr[x][y] = number;
        count++;

        for(int i=0; i<4; i++){
            nowX = x + dirX[i];
            nowY = y + dirY[i];

            if(rangeCheck() && !visited[nowX][nowY] && arr[nowX][nowY] ==1){
                dfs(nowX,nowY);
            }
        }
    }

    static boolean rangeCheck(){
        return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N);
    }
}
