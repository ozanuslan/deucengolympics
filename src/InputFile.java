import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFile {
    public static String[] METADATA;
    //Reads the input file and writes the contents of that file into and array
    public static void open() {
        try {
            int line_count = 0;
            File myObj = new File("C:\\Users\\Ucak\\Desktop\\Olympiad\\out\\production\\Olympiad\\input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                myReader.nextLine();
                line_count++;
            }
            METADATA = new String[line_count];
            int index = 0;
            Scanner myReader2 = new Scanner(myObj);
            while (myReader2.hasNextLine()) {
                String data = myReader2.nextLine();
                METADATA[index] = data;
                index++;
            }
            myReader.close();
            myReader2.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }
}