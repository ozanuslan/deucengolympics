import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFile {
    private static String[] METADATA;
    public static Athlete[] ATHLETE;
    private String[] dataSplit = new String[7];

    // Reads the input file and writes the contents of that file into an array
    public String[] open(String PATH) {
        try {
            int lineCount = 0;
            Scanner myReader = new Scanner(new File(PATH));
            while (myReader.hasNextLine()) {
                myReader.nextLine();
                lineCount++;
            }
            myReader.close();

            METADATA = new String[lineCount];
            int index = 0;
            Scanner myReader2 = new Scanner(new File(PATH));
            while (myReader2.hasNextLine()) {
                String data = myReader2.nextLine();
                METADATA[index] = data;
                index++;
            }
            myReader2.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return METADATA;
    }

    public Athlete[] splitData(){
        //TODO: add metadata info to athletes object array
    }
}