import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFile {
    public static String[] METADATA;
    public static String[][] ATHLETES;

    //Reads the input file and writes the contents of that file into an array
    public static String[] open(String PATH) {
        try {
            int lineCount = 0;
            File myObj = new File(PATH);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                myReader.nextLine();
                lineCount++;
            }
            METADATA = new String[lineCount];
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
        return METADATA;
    }
    public static String[][] splitData(){
        open("/home/ozan/Downloads/input.txt");
        ATHLETES = new String[METADATA.length][6];
        for(int i = 0; i<METADATA.length; i++){
            ATHLETES[i] = METADATA[i].split(",");
            ATHLETES[i][5] = "0";
        }
        return ATHLETES;
    }
}