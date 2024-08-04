import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.rules.ExpectedException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;


public class LionTest {
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самка", feline);
        assertThat("Количество котят не совпадает с ожидаемым",lion.getKittens(), equalTo(5));
    }


    @Test
    public void getLionFoodTest() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы","Рыба"));
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(List.of("Животные", "Птицы","Рыба"), lion.getFood());
    }
    @Test
    public void createLionThrowsExceptionTest() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        new Lion("Не определен", feline);
    }
}