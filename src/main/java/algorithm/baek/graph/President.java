package algorithm.baek.graph;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class President implements TestCase {

    /*
    - 점수가 가장 작은 사람 찾기
    - 최소 점수와 회장이 될 수 있는 모든 사람을 출력
    - 점수는 가장 먼 연결 거리의 수로 계산

    - 입력제한 50명, 종료는 -1 -1

    설계
    - 그래프 연결관계 표현
    - 플로이드 와샬 알고리즘으로 모든 정점간의 최단거리 구하기
    - 개인의 점수는 연결 관계 중 가장 먼 거리의 숫자
     */
    @Override
    public void test() throws ParseException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            Election election = new Election(n);

            while (true) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                if (a == -1 && b == -1) {
                    break;
                }
                election.addConnection(a, b);
            }

            election.floydWarshall();
            election.calculateScore();
            bw.write(election.getResultWithStream() + "\n");
        }
    }
}

class Election {

    static final int INF = 10000000;

    int[][] graph;
    Candidate[] candidates;
    int minScore;
    int n;

    public Election(int n) {
        this.n = n;
        this.graph = new int[n + 1][n + 1];
        this.candidates = new Candidate[n + 1];
        this.minScore = INF;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    graph[i][j] = INF;
                }
            }
        }
    }


    public void addConnection(int a, int b) {
        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    public void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }

    public void calculateScore() {
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] < INF) {
                    max = Math.max(max, graph[i][j]);
                }
            }
            candidates[i] = new Candidate(max, i);
            minScore = Math.min(minScore, max);
        }
    }

    public String getResultWithStream() {
        StringBuilder sb = new StringBuilder();
        List<Candidate> list = Arrays.stream(candidates).filter(candidate -> {
            if (candidate == null) {
                return false;
            }
            return candidate.score == minScore;
        }).sorted().collect(Collectors.toList());

        sb.append(minScore).append(" ").append(list.size()).append("\n");
        for (Candidate candidate : list) {
            sb.append(candidate.number).append(" ");
        }
        return sb.toString().trim();
    }
}

class Candidate implements Comparable<Candidate> {

    int score;
    int number;

    public Candidate(int score, int number) {
        this.score = score;
        this.number = number;
    }

    @Override
    public int compareTo(Candidate o) {
        return this.number - o.number;
    }
}