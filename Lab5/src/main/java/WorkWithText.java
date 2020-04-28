import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WorkWithText {
    public List<String> readFromFile(String file) throws IOException {
        List<String> text = new ArrayList<>();
        FileReader fr = new FileReader(file);
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            text.add(scan.nextLine());
        }

        fr.close();
        return text;
    }

    public List<String> sort(List<String> text) {
        Comparator comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return 0;
                } else if (s1.length() > s2.length()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        List<String> sortedText = text;
        Collections.sort(sortedText,comparator);
        return sortedText;
    }

    public void writeToFile(List<String> text, String file) throws IOException {
        FileWriter fw = new FileWriter(file);
        for (String line :
                text) {
            fw.write(line + "\n");
        }
        fw.close();
    }
}
