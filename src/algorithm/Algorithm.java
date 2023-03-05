package algorithm;

import algorithm.baek.bfs.HideAndSeek;
import algorithm.baek.datastructure.DoublePriorityQueue;
import algorithm.baek.dfs.ConnectedComponent;
import algorithm.baek.dfs.DfsAndBfs;
import algorithm.baek.dynamicprograming.*;
import algorithm.baek.greedy.MeetingRoom;
import algorithm.baek.recursive.QuadTree;
import algorithm.programmers.level2.ConvertingNumber;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        MeetingRoom testCase = new MeetingRoom();

        doTest(testCase);
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new ShCodingTestException(e);
        }
    }
}
