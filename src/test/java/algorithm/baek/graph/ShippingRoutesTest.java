package algorithm.baek.graph;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShippingRoutesTest {

    @DisplayName("데이터를 입력받을 수 있다.")
    @Test
    void inputData() throws IOException {
        //given
        ShippingRoutes shippingRoutes = new ShippingRoutes();
        //when
        String input = "6  7  5\n"
                + "AA CC QR FF DD AB\n"
                + "AA CC\n"
                + "CC QR\n"
                + "DD CC\n"
                + "AA DD\n"
                + "AA AB\n"
                + "DD QR\n"
                + "AB DD\n"
                + "5  AA AB\n"
                + "14 DD CC\n"
                + "1  CC DD\n"
                + "2  AA FF\n"
                + "13 AB QR\n";

        shippingRoutes.setCase(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes()))));
        //then
        Assertions.assertThat(shippingRoutes.getWarehouseCount()).isEqualTo(6);
    }

    @DisplayName("두 개의 창고 이름으로 비용을 조회할 수 있다.")
    @Test
    void searchCost() throws IOException {
        //given
        ShippingRoutes shippingRoutes = new ShippingRoutes();
        //when
        String input = "6  7  5\n"
                + "AA CC QR FF DD AB\n"
                + "AA CC\n"
                + "CC QR\n"
                + "DD CC\n"
                + "AA DD\n"
                + "AA AB\n"
                + "DD QR\n"
                + "AB DD\n"
                + "5  AA AB\n"
                + "14 DD CC\n"
                + "1  CC DD\n"
                + "2  AA FF\n"
                + "13 AB QR\n";

        shippingRoutes.setCase(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes()))));
        //then
        Assertions.assertThat(shippingRoutes.searchCost(5,"AA", "AB")).isEqualTo("$500");
    }

    @DisplayName("최종 결과를 출력할 수 있다")
    @Test
    void getResult() throws IOException {
        //given
        ShippingRoutes shippingRoutes = new ShippingRoutes();
        //when
        String input = "2\n"
                + "6  7  5\n"
                + "AA CC QR FF DD AB\n"
                + "AA CC\n"
                + "CC QR\n"
                + "DD CC\n"
                + "AA DD\n"
                + "AA AB\n"
                + "DD QR\n"
                + "AB DD\n"
                + "5  AA AB\n"
                + "14 DD CC\n"
                + "1  CC DD\n"
                + "2  AA FF\n"
                + "13 AB QR\n"
                + "3 0 1\n"
                + "AA BB CC\n"
                + "5  AA CC";

        shippingRoutes.init(new ByteArrayInputStream(input.getBytes()));
        //then
        Assertions.assertThat(shippingRoutes.getResult()).isEqualTo("DATA SET 1\n"
                + "\n"
                + "$500\n"
                + "$1400\n"
                + "$100\n"
                + "NO SHIPMENT POSSIBLE\n"
                + "$2600\n"
                + "\n"
                + "DATA SET 2\n"
                + "\n"
                + "NO SHIPMENT POSSIBLE");
    }
}