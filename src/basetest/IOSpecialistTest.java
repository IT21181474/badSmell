package basetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import base.IOSpecialist;

class IOSpecialistTest {

    @Test
    void testGetString() {
        IOSpecialist ioSpecialist = new IOSpecialist();
        String result = ioSpecialist.getString();

        // Assuming the logic in IOSpecialist returns a specific string
        assertEquals("Specialist String", result);
    }
}
