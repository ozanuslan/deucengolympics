import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFile {
    public static String[] METADATA;
    private static int MAX_COUNTRY = 20;
    private String[] dataSplit = new String[6];
    public Athlete ATHLETES[] = new Athlete[METADATA.length];
    public Country COUNTRIES[];
    private String[] seenCountry = new String[MAX_COUNTRY];
    private static int countryIndex = 0;
    private boolean isSeen;
    private boolean isFull;

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

    public Country[] fillCountryData(){
        countryIndex = 0;
        for(int i = 0; i < METADATA.length; i++){
            dataSplit = METADATA[i].split(",");
            isSeen = false;
            for(int j = 0; j<seenCountry.length; j++){
                if(dataSplit[0].equalsIgnoreCase(seenCountry[j])){
                    isSeen = true;
                    break;
                }
            }
            if(countryIndex > 20){
                isFull = true;
                break;
            }
            if(!isSeen){
                seenCountry[countryIndex] = dataSplit[0];
                countryIndex++;
            }
        }
        if(isFull){
            //todo: error message
        }

        COUNTRIES = new Country[countryIndex];
        for(int i = 0; i < countryIndex; i++){
            COUNTRIES[i] = new Country(seenCountry[i].toUpperCase());
        }
        
        return COUNTRIES;
    }
    // Fill the object array of athletes for ease of access on the information
    // dataSplit[COUNTRY,SPORT,NAME,GENDER,BIRTHDATE,SKILL]
    public Athlete[] fillAthleteData() {
        for (int i = 0; i < METADATA.length; i++) {
            dataSplit = METADATA[i].split(",");
            ATHLETES[i] = new Athlete(dataSplit[0], dataSplit[1], dataSplit[2], 
            dataSplit[3], dataSplit[4],Double.parseDouble(dataSplit[5]));
        }
        return ATHLETES;
    }
}