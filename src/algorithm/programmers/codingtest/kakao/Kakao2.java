package algorithm.programmers.codingtest.kakao;

import algorithm.TestCase;

import java.text.ParseException;

public class Kakao2 implements TestCase {


    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Service del = new Service(deliveries);
        Service pic = new Service(pickups);

        while (del.getMax() != 0 && pic.getMax() != 0) {
            answer += Math.max(del.doService(cap), pic.doService(cap)) * 2;
        }
        return answer;
    }

    class Service {
        int[] serviceTarget;
        int max;

        public Service(int[] serviceTarget) {
            this.serviceTarget = serviceTarget;
            this.max = serviceTarget.length - 1;
        }

        public int doService(int cap) {
            int ret = max + 1;
            for (int i = max; i >= 0; i--) {
                if (cap >= serviceTarget[i]) {
                    cap -= serviceTarget[i];
                    serviceTarget[i] = 0;
                    max = i;
                } else if (cap != 0) {
                    serviceTarget[i] -= cap;
                    cap = 0;
                    max = i;
                }
                if (cap == 0) {
                    if (i > 1 && serviceTarget[i] == 0) {
                        max = i - 1;
                    }
                    break;
                }
            }
            return ret;
        }

        public int getMax() {
            return max;
        }
    }

    @Override
    public void test() throws ParseException {
        long solution = solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
//        long solution = solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        System.out.println("solution = " + solution);
    }
}
