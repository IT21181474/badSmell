package basetest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.IOLibrary;

class IOLibraryTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    void setUp() {
        // Redirect System.in to provide input for tests
        String input = "Test Input\n127.0.0.1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void testGetString() {
        String expected = "Test Input";
        String result = null;
		try {
			result = IOLibrary.getString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        assertNotNull(result, "The result should not be null");
        
        // Check and trim only if result is not null
        if (result != null) {
            assertEquals(expected, result.trim());
        }
    }


    @AfterEach
    void tearDown() {
        // Reset System.in and System.out to their original states
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    

    @Test
    void testGetIPAddress() {
        String expectedIP = "127.0.0.1";
        InetAddress result = IOLibrary.getIPAddress();
        assertEquals(expectedIP, result.getHostAddress());
    }
}
