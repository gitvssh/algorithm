package programmers.sort;

import java.util.ArrayList;

public class NumberK {
    int[] arrayCase = {1, 5, 2, 6, 3, 7, 4};
    int[][] commandsCase = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    int[] returnsCase = {5, 6, 3};

    private ArrayList<int[]> array = new ArrayList<int[]>();
    private ArrayList commands = new ArrayList<int[][]>();
    private ArrayList returns = new ArrayList<int[]>();

    public void test() {
        array.add(arrayCase);
        commands.add(commandsCase);
        returns.add(returnsCase);

    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        return answer;
    }
}
