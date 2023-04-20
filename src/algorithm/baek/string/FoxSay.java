package algorithm.baek.string;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9536
 * 여우는 어떻게 울지?
 */
public class FoxSay implements TestCase {
    static StringBuilder sb = new StringBuilder();

    @Override
    public void test() throws ParseException, IOException {
        //검사문장 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            HashSet<String> set = new HashSet<>();
            String line = br.readLine();
            while (true) {
                String input = br.readLine();
                if (input.equals("what does the fox say?")) break;
                st = new StringTokenizer(input);
                st.nextToken();
                st.nextToken();
                set.add(st.nextToken());
            }
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (!set.contains(token)) sb.append(token).append(" ");
            }
            sb.append("\n");
        }
        //마지막 줄 제거
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        //종료까지 set에 울음소리 저장
        //검사문장 검사
        //토큰으로 자르기
        //토큰 set에 있는지 확인
        //있으면 패스, 없으면 StringBuilder에 추가
        //최종 출력
    }
}
