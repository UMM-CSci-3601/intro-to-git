import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;


public class HellosTest {

    @Test
    public void testLineStructure() {
        String output = Hellos.generateOutput();
        String[] lines = output.split("\n");
        assertEquals("Welcome line isn't correct.", Hellos.WELCOME_LINE, lines[0]);

        // This regex supports unicode letters spaces, apostrophes, and hyphens
        // Taken from https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters
        // The pattern needs to include some name, the "says", and the single quotes... and they must speak with emphasis
        // as noted by the required "!"
        String linePattern = "[\\p{L} .'-]+ says '+[\\p{L} .'-]+!'";

        for (int i=1; i<lines.length; ++i) {
            assertTrue("Line <" + lines[i] + "> doesn't match", lines[i].matches(linePattern));
        }
    }

}
