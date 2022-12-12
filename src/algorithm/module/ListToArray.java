package algorithm.module;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class ListToArray implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
    }

    public Integer[] solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] % n == 0)
                list.add(numlist[i]);
        }
        return list.stream().toArray(l -> new Integer[l]);
    }
}
