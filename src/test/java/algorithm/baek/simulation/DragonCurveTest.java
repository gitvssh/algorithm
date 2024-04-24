package algorithm.baek.simulation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DragonCurveTest {

    @DisplayName("드래곤커브는 끝점을 기준으로 회전할 수 있다")
    @Test
    public void dragnCurveCanLotate() {
        //given
        DragonCurve.DragonCurveUnit dragonCurveUnit = new DragonCurve.DragonCurveUnit(0, 0, 0,0);
        //when
        dragonCurveUnit.lotate();
        //then
        assertThat(dragonCurveUnit.getGeneration()).isEqualTo(new DragonCurve.DragonCurveUnit(0, 0, 0, 1).getGeneration());
        assertThat(dragonCurveUnit.getLines().size()).isEqualTo(new DragonCurve.DragonCurveUnit(0, 0, 0, 1).getLines().size());
        assertThat(dragonCurveUnit.getLines().get(1).getStart().getX()).isEqualTo(1);
        assertThat(dragonCurveUnit.getLines().get(1).getStart().getY()).isEqualTo(-1);
    }

    @DisplayName("드래곤커브는 지도에 그려질 수 있다.")
    @Test
    public void printMap() {
        //given
        DragonCurve.Map map = new DragonCurve.Map();
        DragonCurve.DragonCurveUnit dragonCurveUnit = new DragonCurve.DragonCurveUnit(3, 3, 0);
        //when
        map.print(dragonCurveUnit);

        //then
        assertThat(map.getPoint(3,3)).isTrue();
    }

    @DisplayName("여러개의 드래곤커브를 지도에 그릴 수 있다.")
    @Test
    public void printMapMultiDrangonCurve() {
        //given
        DragonCurve.Map map = new DragonCurve.Map();
        DragonCurve.DragonCurveUnit dragonCurveUnit = new DragonCurve.DragonCurveUnit(3, 3, 0,1);
        DragonCurve.DragonCurveUnit dragonCurveUnit2 = new DragonCurve.DragonCurveUnit(4, 2, 1,3);
        //when
        map.print(dragonCurveUnit);
        map.print(dragonCurveUnit2);

        //then
        assertThat(map.getPoint(3,3)).isTrue();
        assertThat(map.getPoint(4,2)).isTrue();
    }

    @DisplayName("지도는 정사각형의 개수를 반환할 수 있다.")
    @Test
    public void printSquare() {
        //given
        DragonCurve.Map map = new DragonCurve.Map();
        DragonCurve.DragonCurveUnit dragonCurveUnit = new DragonCurve.DragonCurveUnit(3, 3, 0,1);
        DragonCurve.DragonCurveUnit dragonCurveUnit2 = new DragonCurve.DragonCurveUnit(4, 2, 1,3);
        DragonCurve.DragonCurveUnit dragonCurveUnit3 = new DragonCurve.DragonCurveUnit(4, 2, 2,1);
        DragonCurve.DragonCurveUnit dragonCurveUnit4 = new DragonCurve.DragonCurveUnit(2, 7, 3,4);
        //when
        map.print(dragonCurveUnit);
        map.print(dragonCurveUnit2);
        map.print(dragonCurveUnit3);
        map.print(dragonCurveUnit4);

        //then
        assertThat(map.getSquare()).isNotZero();
        System.out.println(map.getSquare());
    }
}