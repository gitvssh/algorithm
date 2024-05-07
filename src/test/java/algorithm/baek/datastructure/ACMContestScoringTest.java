package algorithm.baek.datastructure;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ACMContestScoringTest {

    @DisplayName("로그 클래스를 만들어 문제를 저장한다.")
    @Test
    void saveLog() {
        //given
        ACMContestScoring.ACMLog log = new ACMContestScoring.ACMLog();
        //when
        log.addLog("7 H right");
        //then
        assertThat(log.getLogs("H")).isNotNull();
    }

    @DisplayName("문제 클래스는 성공여부, 완료 시간, 틀린 횟수를 저장한다.")
    @Test
    void saveLogDetail() {
        //given
        ACMContestScoring.ACMLog log = new ACMContestScoring.ACMLog();
        //when
        log.addLog("7 H right");
        log.addLog("15 B wrong");
        log.addLog("30 E wrong");
        log.addLog("35 E right");
        log.addLog("80 B wrong");
        log.addLog("80 B right");
        log.addLog("100 D wrong");
        log.addLog("100 C wrong");
        log.addLog("300 C right");
        log.addLog("300 D wrong");
        //then
        assertThat(log.getLogs("H").getSolved()).isTrue();
        assertThat(log.getLogs("H").getCompleteTime()).isEqualTo(7);
        assertThat(log.getLogs("H").getFailCount()).isEqualTo(0);
        assertThat(log.getLogs("B").getSolved()).isTrue();
        assertThat(log.getLogs("B").getCompleteTime()).isEqualTo(80);
        assertThat(log.getLogs("B").getFailCount()).isEqualTo(1);
    }

    @DisplayName("문제 클래스는 패널티를 계산할 수 있다.")
    @Test
    void getPanalty() {
        //given
        ACMContestScoring.ACMLog log = new ACMContestScoring.ACMLog();
        //when
        log.addLog("7 H right");
        //then
        assertThat(log.getLogs("H").getPanalty()).isEqualTo(7);
    }

    @DisplayName("로그 클래스는 최종 결과를 출력할 수 있다.")
    @Test
    void getResult() {
        //given
        ACMContestScoring.ACMLog log = new ACMContestScoring.ACMLog();
        //when
        log.addLog("7 H right");
        //then
        assertThat(log.getResult()).isEqualTo("1 7");
    }
}