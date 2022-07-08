package Algorithm.programmers.level1;

import Algorithm.TestCase;

public class Watermelon implements TestCase {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i%2==0){
                sb.append("수");
            }else{
                sb.append("박");
            }
        }
        return sb.toString();
    }
    @Override
    public void test() {
        String solution = solution(3);
        System.out.println("solution = " + solution);
    }
}
