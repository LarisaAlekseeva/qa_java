import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Test
    public void checkEatMeat() throws Exception {
        Feline feline = Mockito.spy(Feline.class);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }
    @Test
    public void checkGetKittens() {
        Feline feline = Mockito.spy(Feline.class);
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        assertEquals(1, feline.getKittens());
    }
    @Test
    public void checkGetKittensCount() {
        assertEquals(1, new Feline().getKittens(1));
    }

    @Test
    public void checkGetFamily() {
        assertEquals("Кошачьи", new Feline().getFamily());
    }
}
