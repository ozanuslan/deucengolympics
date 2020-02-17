import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFile {
    public static String[] METADATA;
    private String[] dataSplit = new String[6];
    public Athlete ATHLETES[] = new Athlete[METADATA.length];

    // Reads the input file and writes the contents of that file into an array
    public static String[] open(String PATH) {
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

    private void initObjects() {
        for (int i = 0; i < ATHLETES.length; i++) {
            ATHLETES[i] = new Athlete();
        }
    }

    // Fill the object array of athletes for ease of access on the information
    public Athlete[] fillAthleteData() {
        initObjects();
        for (int i = 0; i < METADATA.length; i++) {
            dataSplit = METADATA[i].split(",");
            System.out.println(dataSplit[4]);
            ATHLETES[i].setCountry(dataSplit[0]); // Country
            ATHLETES[i].setSport(dataSplit[1]); // Sport
            ATHLETES[i].setName(dataSplit[2]); // Name
            ATHLETES[i].setGender(dataSplit[3]); // Gender
            ATHLETES[i].setBirthDate(dataSplit[4]); // Birthdate
            ATHLETES[i].setSkill(dataSplit[5]); // Skill level
            ATHLETES[i].setPoint(0); // Initial point of the athlete
        }
        return ATHLETES;
    }
}