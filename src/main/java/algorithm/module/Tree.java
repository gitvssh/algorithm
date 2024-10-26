package algorithm.module;

public class Tree {
    /*
    2진트리와 그 외 트리가 존재
    트리란?
    - 계층 구조를 가지고 있는 자료구조
    - 그 외 트리의 특징은?
      - 사이클이 없다
      - 노드, 루트노드, 잎노드, 높이, 서브트리(재귀적 구조)
    트리의 추가 제거, 좌측노드 우측노드
    - 우선순위 큐일 경우 추가할때 정렬함
    트리의 정렬(우선순위 큐)
    트리의 탐색(왼쪽우선 오른쪽우선 중심노드 우선)
     */
    TreeNode root;
    //삽입
    public void insert(int value){
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null){
            return new TreeNode(value);
        }
        if(value < node.getValue()) {
            node.setLeft(insertRecursive(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRecursive(node.getRight(), value));
        }
        return node;
    }
    //탐색

    public boolean search(int value){
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(TreeNode node, int value) {
        if(node == null){
            return false;
        }
        if(value == node.getValue()){
            return true;
        }
        return value < node.getValue() ? searchRecursive(node.getLeft(), value) : searchRecursive(node.getRight(), value);
    }
    //순회

    public void preorderTraversal(TreeNode node){
        if(node!=null){
            visit(node);
            preorderTraversal(node.getLeft());
            preorderTraversal(node.getRight());
        }
    }

    public void inorderTraversal(TreeNode node){
        if(node != null){
            inorderTraversal(node.getLeft());
            visit(node);
            inorderTraversal(node.getRight());
        }
    }

    public void postorderTraversal(TreeNode node){
        if(node != null){
            postorderTraversal(node.getLeft());
            postorderTraversal(node.getRight());
            visit(node);
        }
    }

    private void visit(TreeNode node) {
        System.out.println("doing some : " + node);
    }
}

class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
