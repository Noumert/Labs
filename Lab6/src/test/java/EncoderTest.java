import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class EncoderTest {

    @Test
    void encode() throws IOException {
        Encoder encoder = new Encoder();
        encoder.encode("text.txt", "encoded.txt", 'i');
        InputStreamReader fr = new InputStreamReader(new FileInputStream("encoded.txt"), StandardCharsets.ISO_8859_1);
        Scanner scan = new Scanner(fr);
        String expected = "±ÎÕÕØ";
        String actual = "";
        while (scan.hasNextLine()) {
            actual += scan.nextLine();
        }
        fr.close();
        assertEquals(expected,actual);
    }

    @Test
    void decode() throws IOException {
        Encoder encoder = new Encoder();
        encoder.decode("encoded.txt", "decoded.txt", 'i');
        InputStreamReader fr = new InputStreamReader(new FileInputStream("decoded.txt"), StandardCharsets.ISO_8859_1);
        Scanner scan = new Scanner(fr);
        String expected = "Hello";
        String actual = "";
        while (scan.hasNextLine()) {
            actual += scan.nextLine();
        }
        fr.close();
        assertEquals(expected,actual);
    }
}