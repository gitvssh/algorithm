package algorithm;

import algorithm.leetcode.studyplan75.RunningSum;
import algorithm.module.sort.InsertionSort;

import java.io.IOException;
import java.text.ParseException;

public class Algorithm {

    public static void main(String[] args) throws IOException {
        int[] nums = {1, 2, 3, 4};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(nums);
//        doTest(new RunningSum());
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
