package basetest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import base.SpacePlace;

public class SpacePlaceTest {

    @Test
    public void testDefaultConstructor() {
        SpacePlace spacePlace = new SpacePlace();

        assertEquals(0, spacePlace.getxOrg());
        assertEquals(0, spacePlace.getyOrg());
        assertEquals(0, spacePlace.getTheta(), 0.001); // Double comparison with delta for precision
        assertEquals(0, spacePlace.getPhi(), 0.001);
    }

    @Test
    public void testParameterizedConstructor() {
        double theta = 45.0;
        double phi = 30.0;
        SpacePlace spacePlace = new SpacePlace(theta, phi);

        assertEquals(0, spacePlace.getxOrg());
        assertEquals(0, spacePlace.getyOrg());
        assertEquals(theta, spacePlace.getTheta(), 0.001);
        assertEquals(phi, spacePlace.getPhi(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        SpacePlace spacePlace = new SpacePlace();

        spacePlace.setxOrg(10);
        spacePlace.setyOrg(20);
        spacePlace.setTheta(45.0);
        spacePlace.setPhi(30.0);

        assertEquals(10, spacePlace.getxOrg());
        assertEquals(20, spacePlace.getyOrg());
        assertEquals(45.0, spacePlace.getTheta(), 0.001);
        assertEquals(30.0, spacePlace.getPhi(), 0.001);
    }
}
