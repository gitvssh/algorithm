package algorithm.module;

public class UnionFind {
    public int[] parent;

    public void unionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
    }

    public int find(int[] parent, int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent, parent[a]);
    }
}
