package umm.csci3601;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HellosTest {
    @Test
    public void testLineStructure() {
        String output = Hellos.generateOutput();
        String[] lines = output.split("\n");
        assertEquals(Hellos.WELCOME_LINE, lines[0], "Welcome line isn't correct.");

        // This regex supports unicode letters spaces, apostrophes, and hyphens
        // Taken from https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters
        String linePattern = "[\\p{L} .'-]+ says 'Hello!'";

        for (int i=1; i<lines.length; ++i) {
            assertTrue(lines[i].matches(linePattern),
                "Line <" + lines[i] + "> doesn't match");
        }
    }
}
