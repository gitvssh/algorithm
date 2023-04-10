package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class Kbti implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        Solution solution = new Solution();
//        String[] survey = {"AN","CF","MJ","RT","NA"};
        String[] survey = {"TR", "RT", "TR"};
//        int[] choices = {5,3,2,7,5};
        int[] choices = {7, 1, 3};
        System.out.println(solution.solution(survey, choices));
    }


}

class Solution {
    public String solution(String[] survey, int[] choices) {
        KbtiItem[] items = new KbtiItem[4];
        items[0] = new KbtiItem('R', 'T');
        items[1] = new KbtiItem('C', 'F');
        items[2] = new KbtiItem('J', 'M');
        items[3] = new KbtiItem('A', 'N');
        Kbti kbti = new Kbti(items);
        int tc = survey.length;
        for (int i = 0; i < tc; i++) {
            kbti.input(survey[i], choices[i]);
        }
        return kbti.getResult();
    }

    class Kbti {
        //        int r,t,c,f,j,m,a,n;
        int[] arr = new int[27];
        KbtiItem[] items;

        public Kbti(KbtiItem[] items) {
            this.items = items;
        }

        public void input(String input, int score) {
            char firstChar = input.charAt(0);
            char secondChar = input.charAt(1);
            score -= 4;
            if (score == 0) return;
            char target = (score < 0) ? firstChar : secondChar;
            arr[target - 'A'] += Math.abs(score);
//            switch(target){
//                case('R') :
//                    r += Math.abs(score);
//                    return;
//                case('T') :
//                    t += Math.abs(score);
//                    return;
//                case('C') :
//                    c += Math.abs(score);
//                    return;
//                case('F') :
//                    f += Math.abs(score);
//                    return;
//                case('J') :
//                    j += Math.abs(score);
//                    return;
//                case('M') :
//                    m += Math.abs(score);
//                    return;
//                case('A') :
//                    a += Math.abs(score);
//                    return;
//                default :
//                    n += Math.abs(score);
//                    return;
//            }
        }

        public String getResult() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.items.length; i++) {
                KbtiItem item = this.items[i];
                int firstScore = arr[item.firstChar - 'A'];
                int secondScore = arr[item.secondChar - 'A'];
                if (firstScore < secondScore) {
                    sb.append(item.secondChar);
                } else {
                    sb.append(item.firstChar);
                }
            }
//            sb.append((t > r) ? 'T' : 'R');
//            sb.append((f > c) ? 'F' : 'C');
//            sb.append((m > j) ? 'M' : 'J');
//            sb.append((n > a) ? 'N' : 'A');
            return sb.toString();
        }
    }

    class KbtiItem {
        char firstChar;
        char secondChar;

        public KbtiItem(char firstChar, char secondChar) {
            this.firstChar = firstChar;
            this.secondChar = secondChar;
        }
    }
}
