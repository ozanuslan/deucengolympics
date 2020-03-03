import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFile {
    public static String[] METADATA;
    private String[] dataSplit = new String[6];

    public Athlete[] ATHLETES;
    private static int MAX_ATHLETE = 400;
    private Athlete[] seenAthlete = new Athlete[MAX_ATHLETE];
    private static int athleteIndex = 0;

    public Country[] COUNTRIES;
    private static int MAX_COUNTRY = 20;
    private String[] seenCountry = new String[MAX_COUNTRY];
    private static int countryIndex = 0;

    public Sport[] SPORTS;
    private static int MAX_SPORT = 20;
    private String[] seenSport = new String[MAX_SPORT];
    private static int sportIndex = 0;

    private boolean isSeen;
    private boolean isFull;
    
    private static int athlete_birthdate_day;
    private static int athlete_birthdate_month;
    private static int athlete_birthdate_year;

    // Reads the input file and writes the contents of that file into an array
    public static String[] open(String PATH) {
        try {
            int lineCount = 0;
            Scanner myReader = new Scanner(new File(PATH),"UTF8");
            while (myReader.hasNextLine()) {
                myReader.nextLine();
                lineCount++;
            }
            myReader.close();

            
            String[] CHECKDATA= new String[lineCount];
            int index = 0,counter_wrong_line=0;
            lineCount=0;
            int wrong_num=0;
            Scanner myReaderr = new Scanner(new File(PATH),"UTF8");
            while (myReaderr.hasNextLine()) {
                String data = myReaderr.nextLine();
                CHECKDATA[index] = data;
                String[] str=CHECKDATA[index].split(",");
                if(str.length==6) {
                	try {
                		double point=Double.parseDouble(str[5]);
                		int[] daysPerMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
                    	String[] b_date=str[4].split("\\.");
                    	athlete_birthdate_day=Integer.parseInt(b_date[0]);
                    	athlete_birthdate_month=Integer.parseInt(b_date[1]);
                    	athlete_birthdate_year=Integer.parseInt(b_date[2]);
                    	
                    		if(((point<1&&point>0))&&(athlete_birthdate_year<2001)&&(athlete_birthdate_day>0 && athlete_birthdate_day<daysPerMonth[athlete_birthdate_month-1]&&
                    		   athlete_birthdate_month>0&&athlete_birthdate_month<12)||((athlete_birthdate_year%4==0)&&athlete_birthdate_day==29&&athlete_birthdate_month==02) )//11.15.1954
                    			{lineCount++;}
                	}
                	catch(Exception e) {
                		wrong_num++;
                	}
                }
                else {counter_wrong_line++;}//invalid line-attributes
                index++;  //to get all data               
            }
            myReaderr.close();
            if(wrong_num>0) {
           		System.out.println("Please check the numbers");
            }

            METADATA = new String[lineCount];//6 attributes + valid birthdate
            index = 0;
            for (int i = 0; i < CHECKDATA.length; i++) {
            	String[] str=CHECKDATA[i].split(",");
                if(str.length==6) {
                	try {
                		double point=Double.parseDouble(str[5]);
                		int[] daysPerMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
                    	String[] b_date=str[4].split("\\.");
                    	athlete_birthdate_day=Integer.parseInt(b_date[0]);
                    	athlete_birthdate_month=Integer.parseInt(b_date[1]);
                    	athlete_birthdate_year=Integer.parseInt(b_date[2]);
                    		if(((point<1&&point>0))&&(athlete_birthdate_year<2001)&&(athlete_birthdate_day>0 && athlete_birthdate_day<daysPerMonth[athlete_birthdate_month-1]&&
                         		   athlete_birthdate_month>0&&athlete_birthdate_month<12)||((athlete_birthdate_year%4==0)&&athlete_birthdate_day==29&&athlete_birthdate_month==02)) //11.15.1954
                    			{
                    			METADATA[index]=CHECKDATA[i];
                    			index++;}
                	}
                	catch(Exception e) 
                	{
                	}
                	
                }
             }
                            
            if(counter_wrong_line>0) {
            System.out.println(counter_wrong_line+" wrong lines were founded ");
        }
        	
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return METADATA;
    }

    public Country[] fillCountryData() {
        countryIndex = 0;
        for (int i = 0; i < METADATA.length; i++) {
            dataSplit = METADATA[i].split(",");
            isSeen = false;
            for (int j = 0; j < seenCountry.length; j++) {
                if (dataSplit[0].equalsIgnoreCase(seenCountry[j])) {
                    isSeen = true;
                    break;
                }
            }
            if (countryIndex > 20) {
                isFull = true;
                break;
            }
            if (!isSeen) {
                seenCountry[countryIndex] = dataSplit[0];
                countryIndex++;
            }
        }
        if (isFull) {
            // todo: error message
        }

        COUNTRIES = new Country[countryIndex];
        for (int i = 0; i < countryIndex; i++) {
            COUNTRIES[i] = new Country(seenCountry[i].toUpperCase());
        }

        return COUNTRIES;
    }

    public Sport[] fillSportName() {
        sportIndex = 0;
        for (int i = 0; i < METADATA.length; i++) {
            dataSplit = METADATA[i].split(",");
            isSeen = false;
            for (int j = 0; j < seenSport.length; j++) {
                if (dataSplit[1].equalsIgnoreCase(seenSport[j])) {
                    isSeen = true;
                    break;
                }
            }
            if (sportIndex > 20) {
                isFull = true;
                break;
            }
            if (!isSeen) {
                seenSport[sportIndex] = dataSplit[1];
                sportIndex++;
            }
        }
        if (isFull) {
            // todo: error message
        }

        SPORTS = new Sport[sportIndex];
        for (int i = 0; i < sportIndex; i++) {
            SPORTS[i] = new Sport(seenSport[i].toUpperCase());
        }

        return SPORTS;
    }

    // Fill the object array of athletes for ease of access on the information
    // dataSplit[COUNTRY,SPORT,NAME,GENDER,BIRTHDATE,SKILL]
    public void fillAthleteData() {
        for(int i = 0; i<seenAthlete.length; i++){
            seenAthlete[i] = new Athlete();
        }
        int duplicateAthlete = 0;
        athleteIndex = 0;
        for (int i = 0; i < METADATA.length; i++) {
            dataSplit = METADATA[i].split(",");
            isSeen = false;
            for (int j = 0; j < seenAthlete.length; j++) {
                if (dataSplit[0].equalsIgnoreCase(seenAthlete[j].country)&& dataSplit[1].equalsIgnoreCase(seenAthlete[j].sport)){
                    isSeen = true;
                    break;
                }
            }
            if (athleteIndex > 400) {
                isFull = true;
                break;
            }
            if (!isSeen) {
                seenAthlete[athleteIndex] = new Athlete(dataSplit[0].toUpperCase(), dataSplit[1].toUpperCase(), dataSplit[2] , dataSplit[4] , dataSplit[3], Double.parseDouble(dataSplit[5]));
                athleteIndex++;
            }
            else{
                duplicateAthlete++;
            }
        }
        if (isFull) {
            // todo: error message
        }
        if(duplicateAthlete>0){
            System.out.println(duplicateAthlete+" duplicate athletes found.");
        }

        ATHLETES = new Athlete[athleteIndex];
        for (int i = 0; i < athleteIndex; i++) {
            ATHLETES[i] = new Athlete();
            ATHLETES[i] = seenAthlete[i];
        }
        for(int i = 0; i< ATHLETES.length; i++){
            for (int j = 0; j < SPORTS.length; j++) {
                if (ATHLETES[i].sport.equals(SPORTS[j].sport)) {
                    SPORTS[j].incrementPlayerCount();
                    break;
                }
            }
        }    
    }

    public Sport[] fillSportAthlete() {
        for (int i = 0; i < SPORTS.length; i++) {
            SPORTS[i].initAthleteArr();
        }
        for (int i = 0; i < ATHLETES.length; i++) {
            for (int j = 0; j < SPORTS.length; j++) {
                if(ATHLETES[i].sport.equals(SPORTS[j].sport)){
                    SPORTS[j].ATHLETES_BY_SPORT[SPORTS[j].index] = ATHLETES[i];
                    SPORTS[j].incrementIndex();
                    break;
                }
            }
        }
        return SPORTS;
    }
}