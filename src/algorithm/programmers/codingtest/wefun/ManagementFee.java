package algorithm.programmers.codingtest.wefun;

import algorithm.TestCase;
import lombok.extern.slf4j.Slf4j;

/*
    매달 k일 관리비, k일이 주말이면 가장 가까운 평일에 냄
    1월 1일 요일과, 관리비 내야 한는 날짜 k 매개변수 -> 1~12일까지 평일 or 주말
* */
@Slf4j
public class ManagementFee implements TestCase {
    final static int MONTH_LENGTH = 12;
    int[] monthLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] day = {0, 1, 2, 3, 4, 5, 6};//월,화,수,목,금,토,일

    /*
    1. 관리일 계산 함수 작성
    - 매월 요일 계산하기 or 매월을 365일 단위로 환산 요일 계산하기
    2. return 값은 정확한 일자가 아니고 평일 or 주말 판정만 하면 됨
    3. 관리비가 아니라 k월 day 의 평일/주말 판정, 윤년, 공휴일 고려 x
    4. 평일(0~4)은 0, 주말(5,6)은 1
    * */
    public int[] solution(int day, int k) {

        int[] answer = new int[MONTH_LENGTH];
        int sumMonthDays = day-1;//첫 1일 계산 포함

        for (int i = 0; i <MONTH_LENGTH; i++) {
            int localDay = (sumMonthDays + k) % 7;
            answer[i]=localDay<5?0:1; //5 미만 평일,5 이상 주말
//            log.info("local day : {} 월 {}일",i+1,localDay);
//            log.info("판정 결과 : {}",localDay<5?0:1);
            sumMonthDays += monthLength[i];
        }
        return answer;
    }

    @Override
    public void test() {
        int[] solution = solution(6, 25);
        for (int i : solution) {
            log.info("평일 or 휴일 :{}", i);
        }
    }
}
