import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AnimalParametrizedTest {
    private String animalType;
    private List<String>animalMeal;

    public AnimalParametrizedTest (String animalType, List<String>animalMeal) {
        this.animalMeal = animalMeal;
        this.animalType = animalType;
    }
    @Parameterized.Parameters
    public static Object [][] getParams(){
        return new Object[][] {
                {"Травоядное",List.of("Трава","Различные растения")},
                {"Хищник",List.of("Животные", "Птицы", "Рыба")},
        };
    }
    @Test
    public void getFoodTest() {
        Animal animal = new Animal();
        try {
            assertEquals(animalMeal,animal.getFood(animalType));
        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение травоядное или хищник", exception.getMessage());
        }

    }


}