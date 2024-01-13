package hellos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HellosTest {

  private String[] lines;
  private String output;

  @BeforeEach
  void setUp() {
    Hellos helloRunner = new Hellos();
    output = helloRunner.generateOutput();
    lines = output.split("\n");
  }

  @Test
  void testLineStructure() {
    // This regex supports unicode letters spaces, apostrophes, and hyphens
    // Taken from
    // https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters
    // The pattern needs to include
    // - some name,
    // - the "says",
    // - and the single quotes, and
    // - they must speak with emphasis as noted by the required "!"
    String linePattern = "[\\p{L} .'-]+ says '+[\\p{L} .'-]+!'";

    for (String line : lines) {
      assertTrue(line.matches(linePattern),
          "Line <" + line + "> doesn't match pattern '<Name> says <greeting>!'");
    }
  }

  @Test
  void testAlphabetization() {
    // Make another list that will be sorted
    String[] sortedLines = output.split("\n");
    Arrays.sort(sortedLines);

    // Check that each line matches the line in the sorted list, i.e.,
    // confirm that the generated output is in alphabetical order.
    // Normally we'd like to avoid "raw" `for` loops like this,
    // preferred the `for-each` style used above in `testLineStructure()`.
    // However, here we need to loop over two parallel arrays, and we
    // need the index to report the line number in the error message,
    // and the `for-each` style doesn't support that.
    for (int i = 0; i < lines.length; ++i) {
      assertEquals(sortedLines[i], lines[i], "Sorted lines don't match: "
          + "lines[" + i + "] is: " + lines[i]
          + " and sortedLines[" + i + "] is: " + sortedLines[i]);
    }
  }

}
