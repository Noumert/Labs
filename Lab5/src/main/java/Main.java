import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        WorkWithText workwithText = new WorkWithText();
        List<String> text = workwithText.readFromFile("C:\\Users\\Vova\\Desktop\\Study\\s1.txt");
        text = workwithText.sort(text);
        workwithText.writeToFile(text,"C:\\Users\\Vova\\Desktop\\Study\\s2.txt");

    }
}
