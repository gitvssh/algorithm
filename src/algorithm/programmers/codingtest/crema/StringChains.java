package algorithm.programmers.codingtest.crema;

import algorithm.TestCase;
//import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

//@Slf4j
public class StringChains implements TestCase {
    public static int longestChain(List<String> words) {
        // Write your code here
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        Comparator<String> c = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        };
        words = words.stream().distinct().sorted(c.thenComparing(Comparator.naturalOrder())).collect(Collectors.toList());
//        Collections.sort(words, c);
//        words.sort(Comparator.naturalOrder());
        for (String s : words) {
            System.out.println("s = " + s);
        }
        for (String word : words) {
            //log.info("word :{}", word);
            int length = 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String testWord = sb.deleteCharAt(i).toString();
                //log.info("testWord :{}", testWord);
                if (map.containsKey(testWord)) {
//                    //log.info("containKey :{}",length + map.get(testWord));
                    length = 1 + map.get(testWord);
                    map.put(word, length);
                    max = length > max ? length : max;
                }
                if(words.contains(word))
                map.put(word, length);
            }
        }

        return max;
    }

    @Override
    public void test() {
        int i = longestChain(Arrays.asList(new String[]{"aaaa", "aa", "aaaaaaaa", "bca", "bda", "bdca"}));
        //log.info("max :{}", i);
    }
}
