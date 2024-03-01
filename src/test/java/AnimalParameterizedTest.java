import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;


import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private final String animalType;
    private final List<String> eats;
    private final boolean itsFood;
    public AnimalParameterizedTest(String animalType, List<String> eats, boolean itsFood) {
        this.animalType = animalType;
        this.eats = eats;
        this.itsFood = itsFood;
    }
    @Parameterized.Parameters
    public static Object[][] getAnimalType() {
        return new Object[][] {
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), true},
                {"Травоядное", List.of("Трава", "Различные растения"), true},
                {"Хищник", List.of("Трава", "Различные растения"), false}
        };
    }
    @Test
    public void itGetFood() throws Exception {
        Animal animal = new Animal();
        assertEquals(itsFood, animal.getFood(animalType).equals(eats));
    }
}
