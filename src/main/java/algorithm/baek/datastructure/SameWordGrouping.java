package algorithm.baek.datastructure;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SameWordGrouping implements TestCase {

    /*
    분석(1m)
    설계(2m)
    구현(5m)

    wordHelper
    - 단어를 받아서 정렬한 후 반환
    - 자료구조에 저장
    - 그룹 개수 반환

     */
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        WordHelper wordHelper = new WordHelper();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }
        wordHelper.saveWord(words);
        System.out.println(wordHelper.countGroup());
    }

    public static class WordHelper {

        Set<String> words = new HashSet<>();

        public boolean saveWord(List<String> words) {
            words
                    .forEach(word -> this.words.add(sortAlphabet(word)));
            return true;
        }

        private String sortAlphabet(String word) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        public int countGroup() {
            return words.size();
        }
    }
}
