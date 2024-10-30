package algorithm.baek.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PresidentTest {

    @DisplayName("연결 관계를 등록할 수 있다.")
    @Test
    void canInput() {
        //given
        Election election = new Election(5);
        //when
        election.addConnection(1, 2);
        election.addConnection(2, 3);
        election.addConnection(3, 4);
        election.addConnection(4, 5);
        //then
        Assertions.assertThat(election.graph[1][2]).isEqualTo(1);
    }
}