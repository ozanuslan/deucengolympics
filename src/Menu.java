
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    private void printFixture() {
        for (int i = 0; i < Main.olympiad.TOURNAMENTS.length; i++) {
            System.out.println(Main.olympiad.TOURNAMENTS[i].sport.sport + " Fixture");
            for (int j = 0; j < Main.olympiad.TOURNAMENTS[i].MATCHES.length; j++) {
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.day + ".");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.month + ".");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.year + " ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.hour + ":");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.min + " ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.sport+ " ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.country + "-");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.name + " vs. ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.country + "-");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.name + "  ");
                System.out.println();
            }
        }
    }

    private void printTournaments() {
        for (int i = 0; i < Main.olympiad.TOURNAMENTS.length; i++) {
            System.out.println(Main.olympiad.TOURNAMENTS[i].sport.sport + " Matches");
            for (int j = 0; j < Main.olympiad.TOURNAMENTS[i].MATCHES.length; j++) {
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.day + ".");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.month + ".");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.year + " ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.hour + ":");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.min + " ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.sport+ " ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.country + "-");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.name + " vs. ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.country + "-");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.name + "  ");
                System.out.println("Winner: " + Main.olympiad.TOURNAMENTS[i].MATCHES[j].winner);
            }
        }
    }

    private void showStatistics() {
        showSecondaryMenu();
    }

    public void showPrimaryMenu() {
        System.out.println();
        System.out.println("*****MENU*****");
        System.out.println("1- Generate Fixture");
        System.out.println("2- Perform Tournaments");
        System.out.println("3- Show Statistics");
        System.out.println("4- Exit");
        System.out.println();
        System.out.print("Please enter your choice: ");
        String ans = "";
        boolean isLegal = false;
        while (!isLegal) {
            ans = sc.nextLine();
            if (ans.equals("1") || ans.equals("2") || ans.equals("3") || ans.equals("4")) {
                isLegal = true;
            }
            else{
                System.out.print("Please enter your choice: ");
            }
        }
        if (ans.equals("1")) {
            printFixture();
            showPrimaryMenu();
        } else if (ans.equals("2")) {
            printTournaments();
            showPrimaryMenu();
        } else if (ans.equals("3")) {
            showStatistics();
        }
        else if(ans.equals("4")){

        }

    }

    private void showSecondaryMenu() {
        System.out.println();
        System.out.println("*****STATISTICS MENU*****");
        System.out.println("1- The country with the highest score");
        System.out.println("2- The athlete with the highest score");
        System.out.println("3- List of matches by date");
        System.out.println("4- List of matches by country");
        System.out.println("5- Return to the main menu");
        System.out.println();
        System.out.print("Please select which statistics you would like to see: ");
        String ans = "";
        boolean isLegal = false;
        while (!isLegal) {
            ans = sc.nextLine();
            if (ans.equals("1") || ans.equals("2") || ans.equals("3") || ans.equals("4") || ans.equals("5")) {
                isLegal = true;
            }
            else{
                System.out.print("Please select which statistics you would like to see: ");
            }
        }
        if (ans.equals("1")) {
            printHighestScoringCountry();
            showSecondaryMenu();
        } else if (ans.equals("2")) {
            printHighestScoringAthlete();
            showSecondaryMenu();
        } else if (ans.equals("3")) {
            printMatchesByDate();
            showSecondaryMenu();
        }
        else if(ans.equals("4")){
            printMatchesByCountry();
            showSecondaryMenu();
        }
        else if(ans.equals("5")){
            showPrimaryMenu();
        }
    }

    private Country[] insertionSortCountries(){
        int countryCount = 0;
        countryCount+=Main.olympiad.COUNTRIES.length;
        Country[] sortedCountryArr = new Country[countryCount];

        for(int i=0 ; i<Main.olympiad.COUNTRIES.length; i++){
            sortedCountryArr[i] = Main.olympiad.COUNTRIES[i];
        }

        for (int i = 1; i < countryCount; ++i) { 
            int key = sortedCountryArr[i].point; 
            Country mem = sortedCountryArr[i];
            int j = i-1; 
  
            while (j >= 0 && sortedCountryArr[j].point > key) { 
                sortedCountryArr[j + 1] = sortedCountryArr[j]; 
                j -= 1; 
            } 
            sortedCountryArr[j + 1] = mem; 
        } 
        
        return sortedCountryArr;
    }

    private void printHighestScoringCountry(){
        Country[] orderedCountries = insertionSortCountries();
        int key = orderedCountries[orderedCountries.length-1].point;
        int index = orderedCountries.length-1;
        while(orderedCountries[index].point>=key){
            System.out.println(orderedCountries[index].country+" Score: "+orderedCountries[index].point);
            index--;
        }
    }

    private Athlete[] insertionSortAthletes(){
        int athleteCount = 0;
        for(int i=0 ; i<Main.olympiad.TOURNAMENTS.length; i++){
            athleteCount += Main.olympiad.TOURNAMENTS[i].sport.ATHLETES_BY_SPORT.length;
        }
        Athlete[] sortedAthleteArr = new Athlete[athleteCount];
        int index =0;
        for(int i=0 ; i<Main.olympiad.TOURNAMENTS.length; i++){
            for(int j=0; j<Main.olympiad.TOURNAMENTS[i].sport.ATHLETES_BY_SPORT.length; j++){
                sortedAthleteArr[index] = Main.olympiad.TOURNAMENTS[i].sport.ATHLETES_BY_SPORT[j];
                index++;
            }
        }

        for (int i = 1; i < athleteCount; ++i) { 
            int key = sortedAthleteArr[i].point; 
            Athlete mem = sortedAthleteArr[i];
            int j = i-1; 
  
            while (j >= 0 && sortedAthleteArr[j].point > key) { 
                sortedAthleteArr[j + 1] = sortedAthleteArr[j]; 
                j -= 1; 
            } 
            sortedAthleteArr[j + 1] = mem; 
        } 
        
        return sortedAthleteArr;
    }
    
    private void printHighestScoringAthlete(){
        Athlete[] orderedAthletes = insertionSortAthletes();
        int key = orderedAthletes[orderedAthletes.length-1].point;
        int index = orderedAthletes.length-1;
        while(orderedAthletes[index].point>=key){
            System.out.println(orderedAthletes[index].name+" Score: "+orderedAthletes[index].point);
            index--;
        }
    }

    private void printMatchesByDate(){
        System.out.print("Enter the date which you would like to see the matches of (DD.MM.YYYY): ");
        String dateInput = sc.nextLine();
        String[] dateSplit = dateInput.split("\\.");
        int day;
        int month;
        int year;
        try {  
            day = Integer.parseInt(dateSplit[0]);
            month = Integer.parseInt(dateSplit[1]);
            year = Integer.parseInt(dateSplit[2]);
            
            boolean isFound = false;
            for (int i = 0; i < Main.olympiad.TOURNAMENTS.length; i++) {
                for (int j = 0; j < Main.olympiad.TOURNAMENTS[i].MATCHES.length; j++) {
                    if(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.day == day&&
                    Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.month == month&&
                    Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.year == year){
                        isFound = true;
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.day + ".");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.month + ".");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.year + " ");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.hour + ":");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.min + " ");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.sport+ " ");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.country + "-");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.name + " vs. ");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.country + "-");
                        System.out.println(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.name + "  ");
                    }
                }
            }
            if(!isFound){
                System.out.println("No matches found on specified date.");
            }
         } catch (NumberFormatException e) {  
            System.out.println("Incorrect date format.");
         }
    }

    private void printMatchesByCountry() {
        System.out.print("Enter the country code of the country you would like to see the matches of: ");
        String countryCode = sc.nextLine();
        countryCode = countryCode.toUpperCase();
        boolean isFound = false;
        for (int i = 0; i < Main.olympiad.COUNTRIES.length; i++) {
            if (Main.olympiad.COUNTRIES[i].country.equalsIgnoreCase(countryCode)) {
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("No matching countries found.");
        } else {
            for (int i = 0; i < Main.olympiad.TOURNAMENTS.length; i++) {
                for (int j = 0; j < Main.olympiad.TOURNAMENTS[i].MATCHES.length; j++) {
                    if(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.country.equalsIgnoreCase(countryCode)||
                    Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.country.equalsIgnoreCase(countryCode)){
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.day + ".");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.month + ".");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.year + " ");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.hour + ":");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.min + " ");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.sport+ " ");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.country + "-");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.name + " vs. ");
                        System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.country + "-");
                        System.out.println(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.name + "  ");
                    }
                }
            }
        }
    }
}