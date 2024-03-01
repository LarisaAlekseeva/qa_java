import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Test
    public void checkHasManeException() throws Exception {
        assertThrows(Exception.class, () -> {
            new Lion("Трансгендер", new Feline());
        });
    }
    @Test
    public void lionGetKittensTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        Lion lionSpy = Mockito.spy(lion);
        lionSpy.getKittens();
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lionSpy.getKittens());
    }
    @Test
    public void checkGetFood() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        Lion lionSpy = Mockito.spy(lion);
        lionSpy.getFood();
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lionSpy.getFood());
    }
}


