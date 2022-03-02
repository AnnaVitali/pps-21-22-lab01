import lab01.tdd.AbstractFactorySelectStrategy;
import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.ConcreteFactorySelectStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorySelectStrategyTest {

    private CircularList circularList;
    private AbstractFactorySelectStrategy factory;

    @BeforeEach
    void setUp() {
        circularList = new CircularListImpl();
        factory = new ConcreteFactorySelectStrategy();
    }

    @Test
    void testNextWithEvenStrategy(){
        int firstElement = 1;
        int secondElement = 2;
        int thirdElement = 3;

        circularList.add(firstElement);
        circularList.add(secondElement);
        circularList.add(thirdElement);

        assertEquals(Optional.of(secondElement), circularList.next(factory.createEvenStrategy()));
    }

    @Test
    void testNextWithMultipleOfStrategy(){
        int firstElement = 1;
        int secondElement = 2;
        int thirdElement = 3;

        circularList.add(firstElement);
        circularList.add(secondElement);
        circularList.add(thirdElement);

        assertEquals(Optional.of(secondElement), circularList.next(factory.createMultipleOfStrategy()));
    }

    @Test
    void testNextWithEqualsStrategy(){
        int firstElement = 1;
        int secondElement = 2;
        int thirdElement = 3;

        circularList.add(firstElement);
        circularList.add(secondElement);
        circularList.add(thirdElement);

        assertEquals(Optional.of(thirdElement), circularList.next(factory.createEqualsStrategy()));
    }
}
