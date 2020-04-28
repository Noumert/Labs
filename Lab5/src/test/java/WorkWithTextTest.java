import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkWithTextTest {

    @Test
    void readFromFileTest() throws IOException {
        WorkWithText workWithText = new WorkWithText();
        List<String> actual = workWithText.readFromFile("test.txt");
        List<String> expected = List.of("Hello","My","Friend");
        assertEquals(expected,actual);
    }

    @Test
    void sortTest() {
        WorkWithText workWithText = new WorkWithText();
        List<String> startList = List.of("s1234q","213","1  4");
        List<String> actual = new ArrayList<>();
        actual.addAll(startList);
        workWithText.sort(actual);
        List<String> expected = List.of("213","1  4","s1234q");
        assertEquals(expected,actual);
    }

    @Test
    void writeToFileTest() throws IOException {
        WorkWithText workWithText = new WorkWithText();
        List<String> text = List.of("Hello","My","Friend");
        workWithText.writeToFile(text,"testWrite.txt");
        List<String> actual = workWithText.readFromFile("testWrite.txt");
        List<String> expected = List.of("Hello","My","Friend");
        assertEquals(expected,actual);
    }
}