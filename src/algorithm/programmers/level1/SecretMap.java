package algorithm.programmers.level1;

import algorithm.TestCase;

/*
1. 주어진 int 1차원배열로 2차원 배열 만들기
2. 만들어진 배열 비교
3. 정답 배열 생성
* */
public class SecretMap implements TestCase {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();
        StringBuilder resSb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String bin1 = Integer.toBinaryString(arr1[i]);
            if (bin1.length() < n) {
                for (int j = 0; j < n - bin1.length(); j++) {
                    sb.append("0");
                }
            }
            sb.append(bin1);

            String bin2 = Integer.toBinaryString(arr2[i]);
            if (bin2.length() < n) {
                for (int j = 0; j < n - bin2.length(); j++) {
                    sb2.append("0");
                }
            }
            sb2.append(bin2);
            for (int j = 0; j < n; j++) {
                if ((sb.substring(j, j + 1).equals("0")) && sb2.substring(j, j + 1).equals("0")) {
                    resSb.append(" ");
                } else {
                    resSb.append("#");
                }
            }
            answer[i] = resSb.toString();
            sb.delete(0, n);
            sb2.delete(0, n);
            resSb.delete(0, n);
        }

        return answer;
    }

    @Override
    public void test() {
        solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
    }
}
