package algorithm.programmers.level0;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class NationalCompetition implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int solution = solution(new int[]{1,2,3,}, new boolean[]{true, true, true});
        System.out.println(solution);
    }
    public int solution(int[] rank, boolean[] attendance) {
        int[] newList = new int[4];
        int newIdx = 0;
        int[] rankNumber = new int[rank.length];
        //rank/번호 자료구조(배열) 생성
        for (int i = 0; i < rank.length; i++) {
            rankNumber[rank[i] - 1] = i+1;//랭크 를 0~n-1로 수정
        }
        //rank 순으로 내려가면서, 번호 true값 체크하고 값 계산
        for (int i = 0; i < rank.length; i++) {
            if (attendance[rankNumber[i]-1]) {
                newList[newIdx++] = rankNumber[i]-1;
            }
            if (newIdx > 2) break;
        }
        return (newList[0] * 10000 + newList[1] * 100 + newList[2]);
    }
}
