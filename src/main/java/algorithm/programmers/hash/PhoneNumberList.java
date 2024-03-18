package algorithm.programmers.hash;

import algorithm.TestCase;

import java.util.Arrays;
import java.util.regex.Pattern;

public class PhoneNumberList implements TestCase {
    public boolean solution(String[] phone_book) {
        if (phone_book.length == 1) return true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String pattern = "^"+phone_book[i]+".*";
            if(phone_book[i+1].matches(pattern)) return false;
//            if(phone_book[i+1].contains(phone_book[i])) return false;
//            if (phone_book[i].length() <= phone_book[i + 1].length() && phone_book[i].equals(phone_book[i + 1].substring(0, phone_book[i].length())))
//                return false;
//            for (int j = i+1; j < phone_book.length; j++) {
//                if (phone_book[j].contains(phone_book[i])) {
//                    return false;
//                }
//            }
        }
        return true;
    }

    @Override
    public void test() {
        boolean solution = solution(new String[]{"119", "97674223", "1195524421"});
//        boolean solution = solution(new String[]{"12", "123", "1235","567","88"});
//        boolean solution = solution(new String[]{"123", "456", "789"});
        System.out.println("solution = " + solution);
    }
}
