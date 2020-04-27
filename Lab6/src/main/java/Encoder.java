import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Encoder {

    public void encode(String text,String encoded, char code) throws IOException {
        FileInputStream fin = new FileInputStream(text);
        FileOutputStream fout = new FileOutputStream(encoded);;
        CustomOutputFilter outputFilter = new CustomOutputFilter(fout);
        int j = -1;
        while ((j=fin.read())!=-1){
//            System.out.println((char) (j+(int)code));
            outputFilter.write(j,code);
        }
        outputFilter.close();
    }
    public void decode(String text,String encoded, char code) throws IOException {
        FileInputStream fin = new FileInputStream(text);
        FileOutputStream fout = new FileOutputStream(encoded);;
        CustomOutputFilter outputFilter = new CustomOutputFilter(fout);
        int j = -1;
        while ((j=fin.read())!=-1){
//            System.out.println((char) (j-(int)code));
            outputFilter.write(j,-code);
        }
        outputFilter.close();
    }
}
