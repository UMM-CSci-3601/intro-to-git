package hellos;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HellosTest {

  private String[] lines;
  private String output;

  @BeforeEach
  public void setUp() {
    Hellos helloRunner = new Hellos();
    output = helloRunner.generateOutput();
    lines = output.split("\n");
  }

  @Test
  public void testLineStructure() {
    // This regex supports unicode letters spaces, apostrophes, and hyphens
    // Taken from https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters
    // The pattern needs to include some name, the "says", and the single quotes... and they must speak with emphasis
    // as noted by the required "!"
    String linePattern = "[\\p{L} .'-]+ says '+[\\p{L} .'-]+!'";

    for (int i = 0; i < lines.length; ++i) {
      assertTrue(lines[i].matches(linePattern), "Line <" + lines[i] + "> doesn't match pattern '<Name> says <greeting>!'");
    }
  }

  @Test
  public void testAlphabetization() {
    // Make another list that will be sorted
    String[] sortedLines = output.split("\n");
    Arrays.sort(sortedLines);

    // Check that each line matches the line in the sorted list, i.e.,
    // confirm that the generated output is in alphabetical order.
    for (int i = 0; i < lines.length; ++i) {
      assertEquals(sortedLines[i], lines[i],
        "Line " + i + " doesn't match: lines[" + i + "] is: " + lines[i] + " and sortedLines[" + i + "] is: " + sortedLines[i]);
    }
  }

}
