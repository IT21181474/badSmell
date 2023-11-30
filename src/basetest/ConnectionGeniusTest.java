package basetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import base.ConnectionGenius;

public class ConnectionGeniusTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void testFireUpGame() {
        // Arrange
        InetAddress ipAddress;
        try {
            ipAddress = InetAddress.getByName("127.0.0.1");
            ConnectionGenius connectionGenius = new ConnectionGenius(ipAddress);

            // Act
            connectionGenius.fireUpGame();

            // Assert
            String expectedOutput = "Getting specialized web version." + System.lineSeparator()
                    + "Wait a couple of moments" + System.lineSeparator() + "Connecting" + System.lineSeparator()
                    + "Ready to play" + System.lineSeparator();
            assertEquals(expectedOutput, outputStreamCaptor.toString());
        } catch (UnknownHostException e) {
            fail("Test failed with an exception: " + e.getMessage());
        }
    }

    @Test
    public void testDownloadWebVersion() {
        // Arrange
        ConnectionGenius connectionGenius = new ConnectionGenius(createDummyAddress());

        // Redirect System.out for testing console output
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Act
        connectionGenius.downloadWebVersion();

        // Assert
        String expectedOutput = "Getting specialized web version." + System.lineSeparator()
                + "Wait a couple of moments" + System.lineSeparator();
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testConnectToWebService() {
        // Arrange
        ConnectionGenius connectionGenius = new ConnectionGenius(createDummyAddress());

        // Redirect System.out for testing console output
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Act
        connectionGenius.connectToWebService();

        // Assert
        String expectedOutput = "Connecting" + System.lineSeparator();
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    private InetAddress createDummyAddress() {
        try {
            return InetAddress.getByName("192.168.1.1");
        } catch (UnknownHostException e) {
            fail("Failed to create a dummy InetAddress: " + e.getMessage());
            return null; // This line will never be reached, but needed for compilation
        }
    }
}
