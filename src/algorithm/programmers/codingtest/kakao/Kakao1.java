package algorithm.programmers.codingtest.kakao;

import algorithm.TestCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Kakao1 implements TestCase {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> tmp = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date todayDate = null;

        try {
            todayDate = dateFormat.parse(today);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        HashMap<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            termsMap.put(s[0], Integer.parseInt(s[1]));
        }

        for (int i=0; i<privacies.length; i++) {
            String[] item = privacies[i].split(" ");
            Integer integer = termsMap.get(item[1]);
            try {
                Date validDate = dateFormat.parse(item[0]);
                System.out.println("변환 전validDate = " + validDate);
                validDate.setMonth(validDate.getMonth() + integer);
                System.out.println("변환 후 날짜 validDate = " + validDate);
                System.out.println("현재 날짜 todayDate = " + todayDate);
                System.out.println("todayDate.compareTo(validDate) = " + todayDate.compareTo(validDate));
                if (todayDate.compareTo(validDate) >= 0) {
                    tmp.add(i+1);
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        int[] answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }

        return answer;
    }

    @Override
    public void test() {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12","C 3"};
        String[] privacies = {"2021.05.02 A","2021.07.01 B","2022.02.19 C","2022.02.20 C"};
//        String today = "2020.01.01";
//        String[] terms = {"Z 3", "D 5"};
//        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        int[] solution = solution(today, terms, privacies);
        System.out.println("solution.length = " + solution.length);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
