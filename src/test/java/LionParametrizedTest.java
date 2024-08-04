import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private String sex;
    private boolean haveMane;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public LionParametrizedTest(String sex, boolean haveMane) {
        this.sex = sex;
        this.haveMane = haveMane;
    }
    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Mock
    Feline feline;

    @Test
    public void doesHaveManeTest() throws Exception{
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals("Наличие гривы не совпадает ожидаемым значением.",haveMane,lion.doesHaveMane());
    }

}