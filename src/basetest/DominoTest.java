package basetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import base.Domino;

public class DominoTest {

    private Domino domino;

    @Before
    public void setUp() {
        // Initialize a domino with values 3 and 4
        domino = new Domino(3, 4);
    }

    @Test
    public void testPlace() {
        // Place the domino at coordinates (1, 2) and (3, 4)
        domino.place(1, 2, 3, 4);
        assertTrue(domino.isPlaced());
    }

    @Test
    public void testToStringUnplaced() {
        // Check the string representation of an unplaced domino
        assertEquals("[34]unplaced", domino.toString());
    }

    @Test
    public void testToStringPlaced() {
        // Place the domino at coordinates (1, 2) and (3, 4)
        domino.place(1, 2, 3, 4);
        assertEquals("[34](2,3)(4,5)", domino.toString());
    }

    @Test
    public void testInvert() {
        // Place the domino at coordinates (1, 2) and (3, 4)
        domino.place(1, 2, 3, 4);
        // Invert the domino
        domino.invert();
        assertEquals("[34](4,5)(2,3)", domino.toString());
    }

    @Test
    public void testIsHorizontal() {
        // Place the domino horizontally at coordinates (1, 2) and (1, 3)
        domino.place(1, 2, 1, 3);
        assertFalse(domino.isHorizontal());

        // Place the domino vertically at coordinates (1, 2) and (2, 2)
        domino.place(1, 2, 2, 2);
        assertTrue(domino.isHorizontal());
    }

    @Test
    public void testCompareTo() {
        // Create another domino with higher high value and lower low value
        Domino higherDomino = new Domino(5, 2);

        // Compare the dominoes
        assertTrue(domino.compareTo(higherDomino) > 0);
    }
}

