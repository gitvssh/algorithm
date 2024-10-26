package algorithm.baek.tree;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayList;

public class EscapeTree implements TestCase {

    /*
    분석(5m)
    설계(5m)
    구현(10m)

    - 분석
    - 트리 형태의 보드게임
    - 리프노드를 하나씩 제거함
    - 연산 횟수가 홀수인가 짝수인가 (홀수면 Yes, 짝수면 No);

    - 설계
    - 데이터를 입력받아 트리구조 형태로 구현
    - dfs 탐색으로 리프노드를 하나씩 제거함
    - 총 연산 횟수를 출력
    - 2진 트리가 아님,

    - 이슈
    - 리프노드를 판단하는 방법 문제
    - 리프노드가 제거되는 조건은 루트까지의 거리의 합이 짝수인가 였음
    - 리프노드의 갯수가 아님
     */
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        BoardGame boardGame = new BoardGame(tc);
        String input;
        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }
            String[] line = input.split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            boardGame.insert(a, b);
        }
        bw.write(boardGame.getResult());
        bw.close();
    }


}

class BoardGame {

    int result;
    ArrayList<Integer>[] adjList;

    BoardGame(int n) {
        adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void insert(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    public void dfs(int cur, int parent, int depth) {
        if (adjList[cur].size() == 1 && adjList[cur].get(0) == parent) {
            result += depth;
            return;
        }
        for (int neighbor : adjList[cur]) {
            if (neighbor == parent) {
                continue;
            }
            dfs(neighbor, cur, depth + 1);
        }
    }

    public boolean search(int i) {
        return !adjList[i].isEmpty();
    }

    public String getResult() {
        dfs(1, -1, 0);
        return result % 2 == 1 ? "Yes" : "No";
    }
}