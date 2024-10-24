package algorithm.programmers.codingtest.crema;

import algorithm.TestCase;
//import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;

//@Slf4j
public class ErrorDigitRange implements TestCase {
    public static long findRange(int num) {
        // Write your code here
        ArrayList<Long> list = new ArrayList<>();
        String s = String.valueOf(num);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==0&&(char)(i+'0')==s.charAt(0)) continue;
                list.add(Long.valueOf(s.replace((char) (i + '0'), (char) (j + '0'))));
            }
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size()-1)-list.get(0);
    }

    @Override
    public void test() {
        long range = findRange(123512);
        //log.info("range :{}", range);
    }
}
