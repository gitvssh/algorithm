package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class NumberPair implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        solution("100", "2345");
    }

    public String solution(String X, String Y) {
        //x의 0~9 개수 세기
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        int[] cArr = new int[10];
        for(int i=0;i<X.length();i++){
            xArr[X.charAt(i)-'0']++;
        }
        //y의 0~9 개수 세기
        for(int i=0;i<Y.length();i++){
            yArr[Y.charAt(i)-'0']++;
        }
        //x,y중 작은 쪽의 공통 개수 세기
        for(int i=0;i<10;i++){
            cArr[i] = xArr[i]>=yArr[i]?yArr[i]:xArr[i];
        }
        //큰 수부터 sb.append
        StringBuilder sb = new StringBuilder();
        for(int i=9;i>=0;i--){
            int len = cArr[i];
            for(int j=0;j<len;j++){
                sb.append(i);
            }
        }
        String answer = "";
        if(sb.length()<1) answer = "-1";
        else answer = sb.toString();
        return answer;
    }
}
