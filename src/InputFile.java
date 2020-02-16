import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class InputFile {
    public static String[] METADATA;
    public static String[][] ATHLETES;
    public static Hashtable<String, Integer> POINTS_BY_COUNTRIES;
    public static Hashtable<String, Integer> PLAYERCOUNTS_BY_SPORTS;

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

    // Splits the MetaData by "," to create an accessible array of information for
    // each athlete
    // ATHLETS[][COUNTRY,SPORT,NAME SURNAME,BIRTHDATE,SKILL,POINTS,ATHLETE_NUMBER]
    public static String[][] splitData() {
        ATHLETES = new String[METADATA.length][6];
        for (int i = 0; i < METADATA.length; i++) {
            ATHLETES[i] = METADATA[i].split(",");
            ATHLETES[i][5] = "0"; // Points for tournament
        }
        return ATHLETES;
    }

    public static Hashtable<String, Integer> fillCountryHashtable() {
        POINTS_BY_COUNTRIES = new Hashtable<String, Integer>();
        for (int i = 0; i < ATHLETES.length; i++) {
            if (!POINTS_BY_COUNTRIES.contains(ATHLETES[i][0])) {
                POINTS_BY_COUNTRIES.put(ATHLETES[i][0], 0);
            }
        }
        return POINTS_BY_COUNTRIES;
    }

    public static Hashtable<String, Integer> fillSportHashtable() {
        PLAYERCOUNTS_BY_SPORTS = new Hashtable<String, Integer>();
        int count;
        for (int i = 0; i < ATHLETES.length; i++) {
            String key = ATHLETES[i][1];
            if (!PLAYERCOUNTS_BY_SPORTS.containsKey(key)) {
                PLAYERCOUNTS_BY_SPORTS.put(key, 1);
            } else {
                count = PLAYERCOUNTS_BY_SPORTS.get(key) + 1;
                PLAYERCOUNTS_BY_SPORTS.put(key, count);
            }
        }
        return PLAYERCOUNTS_BY_SPORTS;
    }
}