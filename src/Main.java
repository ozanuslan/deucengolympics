
public class Main {

    static String PATH;
    static Olympiad olympiad;
    public static void main(String[] args) {
        PATH = "input.txt";
        InputFile.open(PATH);
        InputFile file = new InputFile();
        file.fillSportName();
        file.fillAthleteData();
        Sport[] sports_arr = file.fillSportAthlete();
        Country[] country_arr = file.fillCountryData();
        olympiad = new Olympiad(sports_arr, country_arr);
        olympiad.generateTourments();
        Menu menu = new Menu();
        menu.showPrimaryMenu();
    }
}