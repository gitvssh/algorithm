package algorithm.baek.datastructure;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CocktailTest {
    
    @DisplayName("재료를 저장할 수 있다.")
    @Test
    void saveIngredients() throws IOException {
        //given
        Cocktail cocktail = new Cocktail();
        //when
        String input = "3\n"
                + "Wiskey 45\n"
                + "LimeJuice 15\n"
                + "CokeCola 100";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        cocktail.init(is);
        //then
        Assertions.assertThat(cocktail.getIngredients().size()).isEqualTo(3);
    }

    @DisplayName("황금비 칵테일 여부를 확인할 수 있다.")
    @Test
    void isGoldenRatio() throws IOException {
        //given
        Cocktail cocktail = new Cocktail();
        //when
        String input = "3\n"
                + "Wiskey 45\n"
                + "LimeJuice 15\n"
                + "CokeCola 100";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        cocktail.init(is);
        //then
        Assertions.assertThat(cocktail.isGoldenRatio()).isEqualTo("Not Delicious...");

        //given
        Cocktail cocktail2 = new Cocktail();
        //when
        String input2 = "5\n"
                + "Cola 100\n"
                + "Vodka 100\n"
                + "Cola 100\n"
                + "Vodka 50\n"
                + "Cola 42";
        InputStream is2 = new ByteArrayInputStream(input2.getBytes());
        cocktail2.init(is2);
        //then
        Assertions.assertThat(cocktail2.isGoldenRatio()).isEqualTo("Delicious!");
    }

}