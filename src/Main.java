
public class Main {

    static String PATH;

    public static void main(String[] args) {
        PATH = "input.txt";
        InputFile.open(PATH);
        InputFile file = new InputFile();
        file.fillSportName();
        file.fillAthleteData();
        Sport[] sports_arr = file.fillSportAthlete();
        Country[] country_arr = file.fillCountryData();
        Olympiad olympiad = new Olympiad(sports_arr, country_arr);
        olympiad.generateTourments();

        for(int i = 0; i<olympiad.TOURNAMENTS.length; i++){
            System.out.println(olympiad.TOURNAMENTS[i].sport.sport+" Fixture");
            for(int j = 0; j<olympiad.TOURNAMENTS[i].MATCHES.length; j++){
                System.out.print(olympiad.TOURNAMENTS[i].MATCHES[j].date.day+".");
                System.out.print(olympiad.TOURNAMENTS[i].MATCHES[j].date.month+".");
                System.out.print(olympiad.TOURNAMENTS[i].MATCHES[j].date.year+" ");
                System.out.print(olympiad.TOURNAMENTS[i].MATCHES[j].date.hour+":");
                System.out.print(olympiad.TOURNAMENTS[i].MATCHES[j].date.min+" ");
                System.out.print(olympiad.TOURNAMENTS[i].MATCHES[j].ath1.country+"-");
                System.out.print(olympiad.TOURNAMENTS[i].MATCHES[j].ath1.name+" vs. ");
                System.out.print(olympiad.TOURNAMENTS[i].MATCHES[j].ath2.country+"-");
                System.out.print(olympiad.TOURNAMENTS[i].MATCHES[j].ath2.name+"  ");
                System.out.println("Winner: "+olympiad.TOURNAMENTS[i].MATCHES[j].winner);
            }
            System.out.println();
        }
        /*
        for (int i = 0; i < file.ATHLETES.length; i++) {
            System.out.println(file.ATHLETES[i].getCountry() + " " + file.ATHLETES[i].getSport() + " "
                    + file.ATHLETES[i].getName() + " " + file.ATHLETES[i].getGender() + " "
                    + file.ATHLETES[i].getBirthDate() + " " + file.ATHLETES[i].getSkill());
        }
        for (int i = 0; i < file.COUNTRIES.length; i++) {
            System.out.println(Olympiad.COUNTRIES[i].getCountry() + " " + Olympiad.COUNTRIES[i].getPoint());
        }
        */
    }
}