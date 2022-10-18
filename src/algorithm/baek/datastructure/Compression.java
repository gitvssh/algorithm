package algorithm.baek.datastructure;

import algorithm.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Stack;


@Slf4j
public class Compression implements TestCase {
    public int compress(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        int res = 0;
        int curIdx = 0;
        Stack<Character> st = new Stack<>();

        while (curIdx < len) {
            char curChar = chars[curIdx];
            if (curChar == '(') {
                int count = 0;
                while (chars[curIdx] != ')') {
                    count++;
                    curIdx++;
                }
                log.info("{}",count);
                res += (count * (st.pop() - '0'));
            } else {
                st.add(curChar);
                curIdx++;
            }
            log.info("curIdx: {} / {} : {}", curIdx, len, res);
        }

        Iterator<Character> it = st.iterator();

        while (it.hasNext()) {
            log.info("{}",st.pop());
            res++;
        }
        return res;
    }

    @Override
    public void test() throws ParseException {
        int compress = compress("33(562(71(9)))");
        log.info("is start");
        log.info("compress = {}", compress);
    }
}
