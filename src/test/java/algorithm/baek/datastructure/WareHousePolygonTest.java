package algorithm.baek.datastructure;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WareHousePolygonTest {

    @DisplayName("창고는 값을 입력받을 수 있다.")
    @Test
    void init() {
        //given
        WareHousePolygon.WareHouse wareHouse = new WareHousePolygon.WareHouse();
        //when
        String[] input = {
                "2 4",
                "11 4",
                "15 8",
                "4 6",
                "5 3",
                "8 10",
                "13 6"
        };
        wareHouse.init(7, input);
        //then
        assertThat(wareHouse.getPillarsMaxSize()).isEqualTo(7);
    }

    @DisplayName("창고는 면적을 구할 수 있다.")
    @Test
    void getArea() {
        //given
        WareHousePolygon.WareHouse wareHouse = new WareHousePolygon.WareHouse();
        //when
        String[] input = {
                "2 4",
                "11 4",
                "15 8",
                "4 6",
                "5 3",
                "8 10",
                "13 6"
        };
        wareHouse.init(7, input);

        //then
        assertThat(wareHouse.getArea()).isEqualTo(98);
    }
}