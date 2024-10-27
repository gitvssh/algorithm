package algorithm.baek.graph;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeathGameTest {

    @DisplayName("지도를 입력할 수 있다.")
    @Test
    void makeMap() throws IOException {
        //given
        DeathGame deathGame = new DeathGame();
        //when
        String input = "1\n"
                + "500 0 0 500\n"
                + "1\n"
                + "0 0 0 0";

        deathGame.makeMap(new ByteArrayInputStream(input.getBytes()));
        //then
        Assertions.assertThat(deathGame.getMapTileCost(500, 500)).isEqualTo(1);
    }

    @DisplayName("비용을 업데이트할 수 있다.")
    @Test
    void updateCost() throws IOException {
        //given
        DeathGame deathGame = new DeathGame();
        //when
        String input = "1\n"
                + "500 0 0 500\n"
                + "1\n"
                + "0 0 0 0";

        deathGame.makeMap(new ByteArrayInputStream(input.getBytes()));
        deathGame.updateCost();
        //then
        Assertions.assertThat(deathGame.getCost(500, 500)).isEqualTo(1000);
    }

    @DisplayName("결과를 출력할 수 있다.")
    @Test
    void getResult() throws IOException {
        //given
        DeathGame deathGame = new DeathGame();
        //when
        String input = "1\n"
                + "500 0 0 500\n"
                + "1\n"
                + "0 0 0 0";

        deathGame.makeMap(new ByteArrayInputStream(input.getBytes()));
        deathGame.updateCost();
        //then
        Assertions.assertThat(deathGame.getResult()).isEqualTo(1000);
    }
}