package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReportResult implements TestCase {
    public int[] solution(String[] idList, String[] report, int k) {

        /*
         * 처리결과 횟수를 배열로 받음
         * nxn 배열로 확대하고, 주어진 배열 그대로의 인덱스를 사용함
         * 신고한 결과를 나중에 스트림으로 필터링하고 리턴하면 됨
         * */
        int[][] reportBoard = new int[idList.length][idList.length];
        for (String s : report) {
            String[] reportTicket = s.split(" ");
            int reporter = IntStream.range(0, idList.length)
                    .filter(f -> reportTicket[1].equals(idList[f]))
                    .findFirst()
                    .orElse(-1);
            int reportee = IntStream.range(0, idList.length)
                    .filter(f -> reportTicket[0].equals(idList[f]))
                    .findFirst()
                    .orElse(-1);
            reportBoard[reporter][reportee] = 1;
        }

        int[] answer = new int[idList.length];
        for (int[] ints : reportBoard) {
            if (Arrays.stream(ints).sum() >= k) {
                for (int j = 0; j < reportBoard.length; j++) {
                    answer[j] += ints[j] >= 1 ? 1 : 0;
                }
            }
        }

        return answer;
    }

    @Override
    public void test() {
        solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
    }
}
