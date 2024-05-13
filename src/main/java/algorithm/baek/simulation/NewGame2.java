package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.IOException;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/17837
 * 새로운 게임 2
 */
public class NewGame2 implements TestCase {

    /*
    분석(5m)
    - 체스판이 있고, 판 마다 종류가 있음
    - 말은 이동 규칙이 있으며, 위에 쌓일 수 있음
    - 한 턴에 1번부터 k번 까지의 말을 순서대로 이동시킴
    설계(15m)

    체스판
    - 2차원 tile 배열로 구현
    - 타일은 stack, 색을 가지고 있음

    말
    - 말은 이동할 수 있다.
    - 말은 방향을 가지고 있다.
    - 이동할 칸의 색에 따라 다르게 움직인다.
    - 연결관계 구현

    구현(40m)
    o 체스판을 생성할 수 있다.
    o 말을 체스판에 배치할 수 있다.
    - 말을 이동할 수 있다.
    - 말을 순서대로 이동할 수 있다.
    - 말은 이동할 칸의 색에 따라 다르게 움직인다.
    - 게임은 한 턴으로 진행된다.
    - 게임이 종료되는 턴을 출력할 수 있다.
     */
    @Override
    public void test() throws ParseException, IOException {

    }
}
