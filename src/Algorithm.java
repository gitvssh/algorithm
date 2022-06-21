import leetCode.BFS.WordLadder;
import leetCode.DFS.LeetCode209;
import programmers.CodingTest;
import programmers.sort.NumberK;


public class Algorithm {
    public static void main(String[] args) {
//        NumberK numberK = new NumberK();
//        WordLadder testCase = new WordLadder();
//        testCase.test();

        CodingTest codingTest = new CodingTest();
        int solution = codingTest.solution(new int[][]{{5, -1, 4}, {6, 3, -1}, {2, -1, 1}}, 1, 0, new String[]{"go", "go", "right", "go", "right", "go", "left", "go"});
        System.out.println("solution = " + solution);
    }
}
