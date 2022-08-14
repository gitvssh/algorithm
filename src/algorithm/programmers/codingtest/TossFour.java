package algorithm.programmers.codingtest;

import algorithm.TestCase;

public class TossFour implements TestCase {
    // db에서 읽어온 값으로 초대점수 가장 높은 3명 순서대로 구하기
    // 초대 점수 공식 있음
    // 점수가 같으면 마지막 초대가 높은 순위


    public long[] solution(long[][] invitationPairs) {
        long[] answer = {};
        return answer;
    }

    private class User {
        private int id;
        private int invitor = 0;
        private int directCnt = 0;
        private int invitorCnt = 0;
        private int ininvitorCnt = 0;

        public int getScore() {
            return directCnt * 10 + invitorCnt * 3 + ininvitorCnt * 1;
        }
    }

    @Override
    public void test() {
    }
}
