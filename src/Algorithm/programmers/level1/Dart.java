package algorithm.programmers.level1;

import algorithm.TestCase;

import java.util.Arrays;

public class Dart implements TestCase {
    public int solution(String dartResult) {
//        String[] opt = dartResult.replaceAll("[\\d\\w]", "").split("");
//        System.out.println("nums = " + nums);
//        for (String s : opt) {
//            System.out.println("s = " + s);
//        }
//        int i = dartResult.indexOf("*");
//        System.out.println("i = " + i);
//
        int[] score = new int[3];
        String[] split = dartResult.split("");
        int n = 0;
        for (int i = 0; i < split.length; i++) {
            if(split[i].matches("[\\d]")){
                if((Integer.parseInt(split[i]) == 0)&&(Integer.parseInt(split[i])==1)){
                    score[n-1] = 10;
                    continue;
                }
                score[n] = Integer.parseInt(split[i]);
                n++;
                continue;
            }else if(split[i].matches("[A-Z]")){
                switch(split[i]){
                    case "S":
                        break;
                    case "D":
                        score[n-1] = (int)Math.pow(score[n-1],2);
                        break;
                    case "T":
                        score[n-1] = (int)Math.pow(score[n-1],3);
                        break;
                }
            }else {
                if(split[i].equals("*")){
                    for (int j = (n != 0 ? n-2 : 0); j < (n != 0 ? n : 1); j++) {
                        score[j+n-2] = score[j+n-2] * 2;
                    }
                }else{
                    score[n-1] = score[n-1] * -1;
                }
            }

        }
        for (int i : score) {
            System.out.println("i = " + i);
        }
        int answer = Arrays.stream(score).sum();
        return answer;
    }
    @Override
    public void test() {
        int solution = solution("1S2D*3T");
        System.out.println("solution = " + solution);
    }
}
