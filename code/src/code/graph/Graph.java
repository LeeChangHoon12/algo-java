package code.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Graph {

    private ArrayList<ArrayList<Integer>> adjacencyList;

    //그래프 초기화
    public Graph(int initSize){
        this.adjacencyList = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<initSize;i++){
            adjacencyList.add(new ArrayList<Integer>());
        }
    }

    //그래프 반환
    public ArrayList<ArrayList<Integer>> getGraph(){
        return this.adjacencyList;
    }
    //그래프 추가(양방향)
    public void addGraph(int n,int v){
        this.adjacencyList.get(n).add(v);
        this.adjacencyList.get(v).add(n);
    }
    //그래프 추가(단방향)
    public void addSingleGraph(int n,int v){
        this.adjacencyList.get(n).add(v);
    }

    //그래프 출력(인접 리스트)


}
