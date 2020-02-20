
public class Main {

    static String PATH;

    public static void main(String[] args) {
        PATH = "input.txt";
        InputFile.open(PATH);
        InputFile file = new InputFile();
        file.fillAthleteData();
        file.fillCountryData();
        for (int i = 0; i < file.ATHLETES.length; i++) {
            System.out.println(file.ATHLETES[i].getCountry() + " " + file.ATHLETES[i].getSport() + " "
                    + file.ATHLETES[i].getName() + " " + file.ATHLETES[i].getGender() + " "
                    + file.ATHLETES[i].getBirthDate() + " " + file.ATHLETES[i].getSkill());
        }
        for(int i = 0; i<file.COUNTRIES.length; i++){
            System.out.println(file.COUNTRIES[i].getCountry()+" "+file.COUNTRIES[i].getPoint());
        }
    }
}