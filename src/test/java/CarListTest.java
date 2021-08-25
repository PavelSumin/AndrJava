import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarList carList;

    @Before
    public void setUp() throws Exception {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void when_Added_100_Elements_Then_Size_Must_Be_100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void when_Removed_Element_By_Index_Then_Size_Must_Be_Decreased() {
        assertTrue(carList.removeAt(99));
        assertEquals(99, carList.size());
    }

    @Test
    public void when_Removed_Element_As_An_Object_Then_Size_Must_Be_Decreased() {
        Car mercedes = new Car("Mercedes-CLS", 777);
        carList.add(mercedes);
        assertTrue(carList.remove(mercedes));
        assertEquals(100, carList.size());
    }

    @Test
    public void when_Element_Removed_Then_It_Will_Be_Not_Found_As_An_Object() {
        Car mercedes = new Car("Mercedes-CLS", 777);
        carList.add(mercedes);
        carList.remove(mercedes);
        assertFalse(carList.getInfo(mercedes));
    }

    @Test
    public void when_Added_Element_Then_It_Can_Be_Found_As_An_Object() {
        Car mercedes = new Car("Mercedes-CLS", 777);
        carList.add(mercedes);
        assertTrue(carList.getInfo(mercedes));
    }

    @Test
    public void when_Added_Element_Then_It_Can_Be_Found_By_Index() {
        Car mercedes = new Car("Mercedes-CLS", 777);
        carList.add(mercedes);
        assertEquals(mercedes, carList.getInfo(100));
    }

    @Test
    public void when_Elements_Cleared_Then_Size_Must_Be_0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void when_Index_Out_Of_Bounds_Then_Throw_Exception() {
        carList.getInfo(100);
    }

}