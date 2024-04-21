package algorithm.baek.simulation;

import static org.assertj.core.api.Assertions.assertThat;

import algorithm.baek.simulation.Voyager.Direction;
import algorithm.baek.simulation.Voyager.ProbeVoyager;
import algorithm.baek.simulation.Voyager.StarSystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class VoyagerTest {

    @DisplayName("보이저 1호의 위치를 항성계 지도에 배치한다.")
    @Test
    public void placeVoyageOnStarSystem() {
        //given
        StarSystem starSystem = new StarSystem(5, 5);
        starSystem.makeMap(new String[] {
            "../.\\",
            ".....",
            ".C...",
            "...C.",
            "\\.../"
        });
        //when
        starSystem.placeVoyager(new ProbeVoyager(2, 2));
        //then
        assertThat(starSystem.getProbeVoyager()).isNotNull();
        assertThat(starSystem.getProbeVoyager().getX()).isEqualTo(2-1);
    }

    @DisplayName("보이저 1호는 시그널을 보낼 수 있다.")
    @Test
    public void sendSignal() {
        //given
        StarSystem starSystem = new StarSystem(5, 5);
        starSystem.makeMap(new String[] {
                "../.\\",
                ".....",
                ".C...",
                "...C.",
                "\\.../"
        });
        ProbeVoyager voyager = new ProbeVoyager(2, 2);
        starSystem.placeVoyager(voyager);
        //when
        voyager.sendSignal(starSystem);
        //then
        assertThat(starSystem.getProbeVoyager().getMaxSignalLive()).isNotZero();
    }

    @DisplayName("보이저 1호는 시그널의 항성계 내부에서 최대 생존 시간과 방향을 알 수 있다.")
    @Test
    public void getMaxSignalInfo() {
        //given
        StarSystem starSystem = new StarSystem(5, 5);
        starSystem.makeMap(new String[] {
                "../.\\",
                ".....",
                ".C...",
                "...C.",
                "\\.../"
        });
        ProbeVoyager voyager = new ProbeVoyager(3, 3);
        starSystem.placeVoyager(voyager);
        //when
        voyager.sendSignal(starSystem);
        //then
        assertThat(starSystem.getProbeVoyager().getMaxSignalLive()).isEqualTo(17);
        assertThat(starSystem.getProbeVoyager().getMaxDir()).isEqualTo(Direction.U);
    }

    @DisplayName("보이저 1호는 시그널의 항성계 내부에서 최대 생존 시간과 방향을 알 수 있다.")
    @Test
    public void getMaxSignalInfo2() {
        //given
        StarSystem starSystem = new StarSystem(5, 5);
        starSystem.makeMap(new String[] {
                "....\\",
                "\\..\\.",
                "./\\..",
                "\\../C",
                ".\\..//"
        });
        ProbeVoyager voyager = new ProbeVoyager(1, 1);
        starSystem.placeVoyager(voyager);
        //when
        voyager.sendSignal(starSystem);
        //then
        assertThat(starSystem.getProbeVoyager().getMaxSignalLive()).isEqualTo(12);
        assertThat(starSystem.getProbeVoyager().getMaxDir()).isEqualTo(Direction.D);
    }
}