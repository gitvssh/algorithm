package algorithm.programmers.level2;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 * 영어 끝말잇기
 */
public class EndWord implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int[] solution = solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        System.out.println(solution[0] + " " + solution[1]);
    }

    public int[] solution(int n, String[] words) {
        int[] answer = {};
        //알파벳순으로 어레이리스트 선언
        ArrayList<ArrayList<String>> hash = new ArrayList<>();
        //단어의 첫글자로 어레이리스트에 추가하여 해시자료구조 생성
        for(int i=0;i<26;i++){
            hash.add(new ArrayList<>());
        }

        //첫번째 단어 저장
        for(int i=0;i<words.length;i++){
            int idx = words[i].charAt(0)-'a';
            hash.get(idx).add(words[i]);
        }
        //첫단어의 끝글자를 키로 접근, 횟수 카운트
        int count = 1;
        int people = 0;
        String curString = words[0];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<n;j++){
                int lastCharIdx = curString.charAt(words[i].length()-1)-'a';
                ArrayList nextStringSet = hash.get(lastCharIdx);
                if(nextStringSet.isEmpty()){
                    break;
                }
                curString = (String)nextStringSet.get(0);
                nextStringSet.remove(0);

                people = (people+1)%n;
            }
            count++;
        }
        if(count==words.length-1){
            count = 0;
            people = -1;
        }
        //자료가 없으면 총 접근횟수와 사람번호 출력

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        return new int[]{people, count};
    }
}
