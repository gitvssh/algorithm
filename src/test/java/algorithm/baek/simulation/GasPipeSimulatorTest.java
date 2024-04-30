package algorithm.baek.simulation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GasPipeSimulatorTest {

    @DisplayName("지도를 생성할 수 있다.")
    @Test
    void makeMap() {
        //given
        GasPipeSimulator.EuropeanMap europeanMap = new GasPipeSimulator.EuropeanMap(3, 7);
        ArrayList<String> mapData =
                new ArrayList<>();
        mapData.add(".......");
        mapData.add(".M-.-Z.");
        mapData.add(".......");
        europeanMap.update(mapData);
        //when

        //then
        assertThat(europeanMap.getStart().getX()).isEqualTo(1);
        assertThat(europeanMap.getStart().getY()).isEqualTo(1);
        assertThat(europeanMap.getEnd().getX()).isEqualTo(5);
        assertThat(europeanMap.getEnd().getY()).isEqualTo(1);
    }

    @DisplayName("지도는 가스 흐름에 문제가 있는 지점을 찾을 수 있다.")
    @Test
    void checkMap() {
        //given
        GasPipeSimulator.EuropeanMap europeanMap = new GasPipeSimulator.EuropeanMap(3, 7);
        ArrayList<String> mapData =
                new ArrayList<>();
        mapData.add(".......");
        mapData.add(".M-.-Z.");
        mapData.add(".......");
        europeanMap.update(mapData);
        //when
        GasPipeSimulator.Position errorPoint = europeanMap.check();
        //then
        assertThat(errorPoint).isNotNull();
    }

    @DisplayName("지도는 가스 흐름에 문제가 있는 지점을 수정하여 가스 흐름 시뮬레이션을 실행할 수 있다.")
    @Test
    void fixMap() {
        //given
        GasPipeSimulator.EuropeanMap europeanMap = new GasPipeSimulator.EuropeanMap(3, 7);
        ArrayList<String> mapData =
                new ArrayList<>();
        mapData.add(".......");
        mapData.add(".M-.-Z.");
        mapData.add(".......");
        europeanMap.update(mapData);
        //when
        GasPipeSimulator.Position errorPoint = europeanMap.check();
        Boolean result = europeanMap.fixError(errorPoint, GasPipeSimulator.GasPipe.HORIZONTAL);
        //then
        assertThat(result).isTrue();
    }

    @DisplayName("지도는 가스 흐름에 문제가 있는 지점을 수정하여 가스 흐름 시뮬레이션을 실행할 수 있다.")
    @Test
    void printResult() {
        //given
        GasPipeSimulator.EuropeanMap europeanMap = new GasPipeSimulator.EuropeanMap(3, 7);
        ArrayList<String> mapData =
                new ArrayList<>();
        mapData.add(".......");
        mapData.add(".M-.-Z.");
        mapData.add(".......");
        europeanMap.update(mapData);
        //when
        GasPipeSimulator.Position errorPoint = europeanMap.check();
        Boolean result = europeanMap.fixError(errorPoint, GasPipeSimulator.GasPipe.HORIZONTAL);
        //when

        //then
        assertThat(europeanMap.printResult()).isEqualTo("2 4 -");
    }
}