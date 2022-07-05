package Algorithm.programmers.level1;

import Algorithm.TestCase;

public class HashadNumber implements TestCase {
    public boolean solution(int x) {
        int a = x%10;
        int b = x/10%10;
        int c = x/100%10;
        int d = x/1000%10;
        return (x%(a+b+c+d)==0)?true:false;
    }
    @Override
    public void test() {
        boolean solution = solution(10);
        System.out.println("solution = " + solution);
    }
}
