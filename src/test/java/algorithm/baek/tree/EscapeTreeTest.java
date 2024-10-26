package algorithm.baek.tree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EscapeTreeTest {

    @DisplayName("노드를 등록할 수 있다.")
    @Test
    void insertNode() {
        //given
        BoardGame boardGame = new BoardGame(2);
        //when
        boardGame.insert(2, 1);
        //then
        assertThat(boardGame.search(2)).isTrue();
        assertThat(boardGame.search(1)).isTrue();
    }

    @DisplayName("결과값을 출력할 수 있다.")
    @Test
    void getResult() {
        //given
        BoardGame boardGame = new BoardGame(2);
        //when
        boardGame.insert(2, 1);
        //then
        assertThat(boardGame.getResult()).isEqualTo("Yes");
    }
}