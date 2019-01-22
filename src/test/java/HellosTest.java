import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class HellosTest {

  String[] lines;

  @Before
  public void setUp() {
    String output = Hellos.generateOutput();
    lines = output.split("\n");
  }

  @Test
  public void testLineStructure() {

    assertEquals("Welcome line isn't correct.", Hellos.WELCOME_LINE, lines[0]);

    // This regex supports unicode letters spaces, apostrophes, and hyphens
    // Taken from https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters
    // The pattern needs to include some name, the "says", and the single quotes... and they must speak with emphasis
    // as noted by the required "!"
    String linePattern = "[\\p{L} .'-]+ says '+[\\p{L} .'-]+!'";

    for (int i = 1; i < lines.length; ++i) {
      assertTrue("Line <" + lines[i] + "> doesn't match", lines[i].matches(linePattern));
    }
  }

  @Test
  public void testAlphabetization() {
    // Make another list that will be sorted except for the first line
    String output = Hellos.generateOutput();
    String[] sortedLines = output.split("\n");
    Arrays.sort(sortedLines, 1, sortedLines.length);

    // Don't check the first line since we do that elsewhere, but compare the rest to be sure
    // the actual list matches the sorted list
    for (int i = 1; i < lines.length; ++i) {
      assertTrue("Line " + i + " doesn't match: lines[" + i + "] is: " + lines[i] +
        " and sortedLines[" + i + "] is: " + sortedLines[i], lines[i].equals(sortedLines[i]));
    }
  }

}
