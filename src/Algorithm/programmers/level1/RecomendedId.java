package algorithm.programmers.level1;

import algorithm.TestCase;

public class RecomendedId implements TestCase {
    public String solution(String new_id) {
        System.out.println(new_id);
        //1단계
        String s1 = new_id.toLowerCase();
        System.out.println(s1);
        //2단계
        String s2 = s1.replaceAll("[^a-z0-9\\-\\_\\.]", "");
        System.out.println(s2);
        //3단계
        String s3 = s2.replaceAll("[\\.]+", ".");
        System.out.println(s3);
        //4단계
        String s4 = s3.replaceAll("^[.]+", "");
        s4 = s4.replaceAll("\\.$", "");
        //5단계
        if (s4.length() == 0) s4 = "a";
        System.out.println(s4);
        //6단계
        String s5 = s4.substring(0, s4.length() > 15 ? 15 : s4.length());
        s5 = s5.replaceAll("\\.$", "");
        System.out.println(s5);
        //7단계
        if (s5.length() < 3) {
            String temp = s5.substring((s5.length() - 1) >= 0 ? (s5.length() - 1) : 0);
            while (s5.length() != 3) {
                s5 += temp;
            }
        }
        return s5;
    }

    private static class KAKAOID {
        private String s;

        public KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot(){
            s = s.replaceAll("^[.][.]$", "");
            return this;
        }

        private KAKAOID noBlank(){
            s = s.isEmpty()? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16(){
            if(s.length()>15){
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLeeThan2(){
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() <= 2) {
                sb.append(sb.charAt(sb.length() - 1));
            }
            s = sb.toString();
            return this;
        }

        private String getResult(){
            return s;
        }
    }


    @Override
    public void test() {
        String solution = solution("123_.def");
        System.out.println("solution = " + solution);
    }
}
