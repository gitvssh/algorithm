package Algorithm.programmers.level1;

import Algorithm.TestCase;

import java.util.regex.Pattern;

public class PandY implements TestCase {
    boolean solution(String s) {
//        long pNum = 0L;
//        long yNum = 0;
//
//        pNum = s.toLowerCase().chars().filter(a -> a == 'p').count();
//        yNum = s.toLowerCase().chars().filter(a -> a == 'y').count();
//        return (pNum==yNum)?true:false;
        String pattern = "[^pPyY]";
        String s2= s.replaceAll(pattern,"").toLowerCase();
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            if(s2.charAt(i)=='p'){
                count++;
            }else{
                count--;
            }
        }
        return count==0?true:false;
    }
    @Override
    public void test() {
        boolean pPoooyY = solution("pPoooyY");
        System.out.println("pPoooyY = " + pPoooyY);
    }
}
