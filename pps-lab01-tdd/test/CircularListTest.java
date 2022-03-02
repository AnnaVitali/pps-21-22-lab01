import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void setUp() {
        circularList = new CircularListImpl();
    }

    @Test
    void testEmpty(){
      assertTrue(circularList.isEmpty());
    }

    @Test
    void testAddElement(){
        int element = 1;
        circularList.add(element);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testListSize(){
        int element = 1;
        circularList.add(element);
        assertEquals(1, circularList.size());
    }

    @Test
    void testNext(){
        int element = 1;
        circularList.add(element);
        assertEquals(Optional.of(element), circularList.next());
    }

    @Test
    void testCircularNext(){
        int firstElement = 1;
        int secondElement = 2;
        int thirdElement = 3;

        circularList.add(firstElement);
        circularList.add(secondElement);
        circularList.add(thirdElement);

        circularList.next();
        circularList.next();
        circularList.next();

        assertEquals(circularList.next(), Optional.of(firstElement));
    }

    @Test
    void testPrevious(){
        int element = 1;
        circularList.add(element);
        assertEquals(Optional.of(element), circularList.previous());
    }

    @Test
    void testCircularPrevious(){
        int firstElement = 1;
        int secondElement = 2;
        int thirdElement = 3;

        circularList.add(firstElement);
        circularList.add(secondElement);
        circularList.add(thirdElement);

        circularList.previous();
        circularList.previous();
        circularList.previous();

        assertEquals(circularList.next(), Optional.of(firstElement));
    }

    @Test
    void testReset(){
        int firstElement = 1;
        int secondElement = 2;
        int thirdElement = 3;

        circularList.add(firstElement);
        circularList.add(secondElement);
        circularList.add(thirdElement);

        circularList.next();
        circularList.next();

        circularList.reset();

        assertEquals(Optional.of(firstElement), circularList.previous());
    }






}
