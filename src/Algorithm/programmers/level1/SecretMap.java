package Algorithm.programmers.level1;

import Algorithm.TestCase;

        /*
        1. 주어진 int 1차원배열로 2차원 배열 만들기
        2. 만들어진 배열 비교
        3. 정답 배열 생성
        * */
public class SecretMap implements TestCase {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        long before = System.currentTimeMillis();
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String d = sb2.append("%0").append(n).append("d").toString();
        long after1 = System.currentTimeMillis();
        System.out.println("SecretMap.solution");
        System.out.println(before-after1);
        double v = 0;
        double v2 = 0;
        boolean chk = false;
        boolean chk2 = false;
        for (int i = 0; i < n; i++) {
            v = arr1[i];
            v2 = arr1[i];
            for (int j = 0; j < n; j++) {
//                System.out.println(Integer.toBinaryString(arr1[i]));
//                String s1 = String.format(d,Integer.parseInt(Integer.toBinaryString(arr1[i])));
//                String s2 = String.format(d,Integer.parseInt(Integer.toBinaryString(arr2[i])));
//                if ((s1.charAt(j) == '0') && (s2.charAt(j) == '0')) {
                if(v - Math.pow(2, n-j-1)>0){
                    v-=Math.pow(2, n-j-1);
                    chk = true;
                }
                if(v2 - Math.pow(2, n-j-1)>0){
                    v2-=Math.pow(2, n-j-1);
                    chk2 = true;
                }
                if(chk &&chk2==true){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
                chk = false;
                chk2 = false;
            }
            v=0;
            v2=0;
            long l = System.currentTimeMillis();
            answer[i] = sb.toString();
            sb.delete(0, n);
        }
        long l = System.currentTimeMillis();
        System.out.println(l-before);
        for (String s : answer) {
            System.out.println("s = " + s);
        }

        return answer;
    }
            @Override
    public void test() {
        String[] solution = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
    }
}
