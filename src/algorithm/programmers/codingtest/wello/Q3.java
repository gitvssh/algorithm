package algorithm.programmers.codingtest.wello;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class Q3 implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        String votes = "AAAABCCCCC";
        VoteUtil voteUtil = new VoteUtil();
        voteUtil.countVotes(votes);
        System.out.println(voteUtil.getResult());
    }

    class VoteUtil {
        private int voteA;
        private int voteB;
        private int abstention;

        public void countVotes(String votes) {
            for (int i = 0; i < votes.length(); i++) {
                char vote = votes.charAt(i);
                if (vote == 'A') {
                    voteA++;
                } else if (vote == 'B') {
                    voteB++;
                } else {
                    abstention++;
                }
            }
        }

        public String getResult() {
            if (abstention >= getTotalVotes() / 2) {
                return "C";
            } else if (voteA > voteB) {
                return "A";
            } else if (voteA < voteB) {
                return "B";
            } else {
                return "AB";
            }
        }

        private int getTotalVotes() {
            return voteA + voteB + abstention;
        }
    }
}
