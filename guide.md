🎯 알고리즘 문제 해결 7단계 프로세스

1. 문제 분석 단계 (10분)

✓ 문제를 3번 정독하며 핵심 요구사항 파악
✓ 제약조건과 엣지케이스 명시적으로 정리
✓ 입출력 형식 확인
✓ 시간/공간 복잡도 제한 확인

2. 솔루션 설계 단계 (15분)

✓ 문제 유형 분류 (DP, 그래프, 그리디 등)
✓ 접근법 2-3개 브레인스토밍
✓ 의사코드(pseudo-code) 작성
✓ 시간복잡도 예상 계산

3. 테스트 케이스 설계 (5분)

// 테스트 우선 작성 (TDD)
@Test
void 기본_케이스() { }

@Test
void 엣지_케이스_최소값() { }

@Test
void 엣지_케이스_최대값() { }

@Test
void 예외_케이스() { }

4. 최소 구현 (MVP) (20분)

// 1. 인터페이스 정의
public int solve(int[] input) {
return -1; // 실패 케이스
}

// 2. 가장 단순한 케이스만 통과
public int solve(int[] input) {
if (input.length == 1) return input[0];
return -1;
}

// 3. 점진적 확장

5. 리팩토링과 최적화 (15분)

✓ 중복 코드 제거
✓ 변수명/함수명 개선
✓ 헬퍼 메서드 추출
✓ 시간/공간 복잡도 개선

6. 검증과 디버깅 (10분)

// 디버깅 템플릿
private void debug(String label, Object value) {
if (DEBUG) System.out.println(label + ": " + value);
}

// 상태 추적
debug("현재 인덱스", i);
debug("누적값", sum);

7. 회고와 학습 (5분)

✓ 사용한 알고리즘 패턴 문서화
✓ 실수했던 부분 기록
✓ 더 나은 해법 조사
✓ 유사 문제 연결

📝 실전 적용 템플릿

public class Solution {
// 1. 문제 정의 주석
/*
* 문제: [문제 요약]
* 입력: [입력 형식]
* 출력: [출력 형식]
* 제약: [제약사항]
*
* 접근법: [선택한 알고리즘]
* 시간복잡도: O(?)
* 공간복잡도: O(?)
*/

      // 2. 핵심 로직 메서드
      public int solve(int[] nums) {
          // 엣지 케이스 처리
          if (nums == null || nums.length == 0) {
              return 0;
          }

          // 메인 로직
          return helper(nums, 0);
      }

      // 3. 헬퍼 메서드
      private int helper(int[] nums, int start) {
          // 구현
      }

      // 4. 유틸리티 메서드
      private boolean isValid(int n) {
          return n >= 0 && n < nums.length;
      }
}

🚀 학습 효과 극대화 팁

매일 연습 루틴

1. Easy 1문제 → 패턴 익히기 (20분)
2. Medium 1문제 → 사고력 확장 (40분)
3. 복습 1문제 → 이전 풀이 개선 (20분)

문제 풀이 후 체크리스트

- 다른 사람 풀이 3개 이상 분석
- 시간복잡도 개선 가능한가?
- 코드 가독성 개선 가능한가?
- 비슷한 문제 패턴 정리

실수 방지 체크포인트

⚠️ 배열 인덱스 범위 체크
⚠️ null/empty 입력 처리
⚠️ 정수 오버플로우 고려
⚠️ = vs == 실수
⚠️ off-by-one 에러