package algorithm.baek.datastructure;

import algorithm.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.Stack;


//@Slf4j
public class Compression implements TestCase {
    public int compress(String str) {

        int len = str.length();
        char[] chars = str.toCharArray();
        int res = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            st.add(chars[i]);
        }
        while (!st.isEmpty()) {
            if (st.pop() == ')') {
                res += countBracket(st);
            } else {
                res++;
            }
        }
        return res;
    }

    private int countBracket(Stack<Character> st) {
        if (st.isEmpty()) {
            return 0;
        }

        int cnt = 0;
        while (st.peek() != '(') {
            if (st.pop() == ')') {
                cnt += countBracket(st);
            } else {
                cnt++;
            }
        }
        st.pop();
        int multiple = st.isEmpty() ? 0 : st.pop() - '0';
        //log.info("cnt: {}, multiple: {}", cnt, multiple);
        return cnt * multiple;
    }

    @Override
    public void test() throws ParseException {
        int compress = compress("1()66(5)");
        //log.info("compress = {}", compress);
    }
}
