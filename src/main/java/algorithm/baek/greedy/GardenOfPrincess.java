package algorithm.baek.greedy;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GardenOfPrincess implements TestCase {

    /*
    입력:
    - 꽃들의 총 개수 N(1~100,000)
    - 꽃이 피는 날짜와 지는 날짜 x N
    출력:
    - 선택한 꽃들의 최소 개수

    설계
    - 최소값 찾기(집합에서 주어진 조건 선택)
    - 꽃을 길이 시작날짜 순으로 정렬해서 주어진 조건에 맞게 차례대로 선택

    피드백
    - TDD 없으니 피드백 받기 힘듦
     */
    @Override
    public void test() throws ParseException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            Flower[] flowers = new Flower[n];
            for (int i = 0; i < n; i++) {
                flowers[i] = new Flower(br.readLine());
            }
            Arrays.sort(flowers);
            final int BASE_YEAR = 2023;
            LocalDate start = LocalDate.of(BASE_YEAR, 3, 1);
            LocalDate end = LocalDate.of(BASE_YEAR, 12, 1);

            int count = 0;
            int idx = 0;
            LocalDate maxEnd = start;

            //1. [x]시작날짜, 종료날짜 비교
            //2. [x]선택한 값이 종료날짜 이전인 동안 반복
            //3. [x]탐색 대상의 시작일이 이전 꽃의 이전 꽃의 종료일보다 이후이면 선택 안함
            //4. [x]탐색 대상의 기간이 이전 최대값보다 크면 선택
            while (start.isBefore(end)) {
                boolean find = false;
                for (int i = idx; i < n; i++) {
                    if (flowers[i].getStart().isAfter(start)) {
                        break;
                    }
                    if (flowers[i].getEnd().isAfter(maxEnd)) {
                        maxEnd = flowers[i].getEnd();
                        idx = i;
                        find = true;
                    }
                }
                if (!find) {
                    count = 0;
                    break;
                }
                start = flowers[idx].getEnd();
                count++;
                idx++;
            }

            bw.write(String.valueOf(count));
        }
    }

}

class Flower implements Comparable<Flower> {

    private final LocalDate start;
    private final LocalDate end;

    Flower(String str) {
        StringTokenizer st = new StringTokenizer(str);
        start = LocalDate.of(2023, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        end = LocalDate.of(2023, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }


    //equals, hashCode, toString 생략
    @Override
    public int compareTo(Flower o) {
        if (this.start.equals(o.start)) {
            return o.end.compareTo(this.end);
        }
        return this.start.compareTo(o.start);
    }
}