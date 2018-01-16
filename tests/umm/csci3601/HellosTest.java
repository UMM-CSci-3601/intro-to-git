package umm.csci3601;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HellosTest {
    @Test
    public void testLineStructure() {
        String output = Hellos.generateOutput();
        String[] lines = output.split("\n");
        Hellos.WELCOME_LINE.equals(lines[0]);

        String linePattern = "\\w+ says 'Hello!'";

        for (int i=1; i<lines.length; ++i) {
            assertTrue(lines[i].matches(linePattern),
                "Line <" + lines[i] + "> doesn't match");
        }
    }
}
