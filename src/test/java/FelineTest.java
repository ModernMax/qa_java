import com.example.Feline;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FelineTest {
    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        assertThat(feline.eatMeat(),
                equalTo(feline.getFood("Хищник")));
    }

    @Test
    public void getFamilyTest() {
        String expectedFelineFamilyReturn = "Кошачьи";

        assertThat("Это животное не из семейства кошачьих.",
                new Feline().getFamily(),
                equalTo(expectedFelineFamilyReturn));
    }

    @Test
    public void getKittensIsDefaultValue() {
        int expectedQuantityOfKittens = 1;
        assertThat("Неправильное количество котят.",
                new Feline().getKittens(),
                equalTo(expectedQuantityOfKittens));
    }

    @Test
    public void getKittensTest() {
        int expectedQuantityOfKittens = 4;
        assertThat("Неправильное количество котят.",
                new Feline().getKittens(expectedQuantityOfKittens),
                equalTo(expectedQuantityOfKittens));

    }


}