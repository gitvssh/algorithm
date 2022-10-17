package algorithm;

import algorithm.baek.datastructure.Compression;

import java.text.ParseException;


public class Algorithm {
    public static void main(String[] args) {
        TestCase testCase = new Compression();
        try {
            testCase.test();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
