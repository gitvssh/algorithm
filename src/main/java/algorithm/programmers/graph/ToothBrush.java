package algorithm.programmers.graph;

import algorithm.TestCase;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ToothBrush implements TestCase {

    @Override
    public void test() throws ParseException, IOException {

    }
}

class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Graph graph = new Graph();
        int n = enroll.length;
        for (int i = 0; i < n; i++) {
            Node parent = null;
            if (referral[i] != "-") {
                parent = graph.search(referral[i]);
            }
            graph.add(new Node(parent, enroll[i]));
        }
        HashMap<String, Integer> incomes = new HashMap<String, Integer>();
        int m = seller.length;
        for (int i = 0; i < m; i++) {
            incomes.put(seller[i], incomes.getOrDefault(seller[i], 0) + amount[i] * 100);
        }
        for (String name : incomes.keySet()) {
            Node node = graph.search(name);
            if (node != null) {
                node.addIncome(incomes.get(name));
            }
        }

        return graph.getResult();
    }
}
/*
입력
enroll : 노드 리스트
referall : 부모 리스트
seller, ammount , result : 각 노드의 값

로직:
데이터 입력받아 트리 구조 생성
수입 등록 시 부모에게 분배되는 로직 개발
계산된 수입 등록


출력
분배금 정산 완료 후 개개인의 값

*/

class Graph {

    List<Node> graph;
    HashMap<String, Integer> map;
    int idx;

    Graph() {
        this.graph = new ArrayList<>();
        this.map = new HashMap<String, Integer>();
        this.idx = 0;
    }

    public Node search(String name) {
        Integer nodeIdx = map.get(name);
        if (nodeIdx == null) {
            return null;
        }
        return graph.get(nodeIdx);
    }

    public void add(Node node) {
        graph.add(node);
        map.put(node.getName(), idx++);
    }

    public int[] getResult() {
        int[] result = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            result[i] = graph.get(i).getIncome();
        }
        return result;
    }
}

class Node {

    private Node parent;
    private List<Node> childs;
    private String name;
    private int income;

    Node(Node parent, String name) {
        this.parent = parent;
        this.childs = new ArrayList<>();
        this.name = name;
        income = 0;
        if (parent != null) {
            parent.addChild(this);
        }
    }

    public String getName() {
        return this.name;
    }

    public void addChild(Node child) {
        childs.add(child);
    }

    public void addIncome(int profit) {
        int profitToParent = profit / 10;
        this.income += profit - profitToParent;
        if (this.parent != null && profitToParent >= 1) {
            this.parent.addIncome(profitToParent);
        }
    }

    public int getIncome() {
        return this.income;
    }
}
