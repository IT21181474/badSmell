package basetest;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

import base.Location;

public class LocationTest {

	@Test
    public void testGetInt() {
        // Create a ByteArrayInputStream to simulate input
        ByteArrayInputStream inputStream = new ByteArrayInputStream("42\n".getBytes());
        System.setIn(inputStream);

        // Test the getInt() method
        int result = Location.getInt();
        assertEquals(42, result);

        // Reset System.in to the original InputStream
        System.setIn(System.in);
    }
	
    @Test
    public void testLocationConstructorWithoutDirection() {
        // Test the constructor without specifying direction
        Location location = new Location(2, 3);
        assertEquals(2, location.r);
        assertEquals(3, location.c);
        assertNull(location.d); // Direction should be null
    }

    @Test
    public void testLocationConstructorWithDirection() {
        // Test the constructor with specifying direction
        Location location = new Location(2, 3, Location.DIRECTION.HORIZONTAL);
        assertEquals(2, location.r);
        assertEquals(3, location.c);
        assertEquals(Location.DIRECTION.HORIZONTAL, location.d);
    }

    @Test
    public void testToStringWithoutDirection() {
        // Test the toString method without specifying direction
        Location location = new Location(2, 3);
        assertEquals("(4,3)", location.toString()); // Assuming 3 + 1 = 4 for column
    }

    @Test
    public void testToStringWithDirection() {
        // Test the toString method with specifying direction
        Location location = new Location(2, 3, Location.DIRECTION.VERTICAL);
        assertEquals("(4,3,VERTICAL)", location.toString()); // Assuming 3 + 1 = 4 for column
    }
}
