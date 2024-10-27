package algorithm.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dijkstra {

    public void init(){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        int start = sc.nextInt();

        // 그래프 연결관계 만들고
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(a).add(new Node(b, cost));
        }

        // 방문여부, 거리 배열 만들기
        boolean[] visited = new boolean[v+1];
        int[] dist = new int[v+1];

        for (int i = 0; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        // 최소 비용 노드 선택
        for (int i = 0; i < v; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;
            for (int j = 0; j < v + 1; j++) {
                if(!visited[j] && dist[j]<nodeValue){
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true;

            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node adjNode = graph.get(nodeIdx).get(j);
                if(dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost){
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                }
            }
        }

        // 거리값 갱신
    }

}

class Node{
    int idx;
    int cost;

    Node (int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }
}