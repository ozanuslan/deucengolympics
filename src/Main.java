
public class Main {

    static String PATH;

    public static void main(String[] args) {
        PATH = "C:\\Users\\Ucak\\Downloads\\input.txt";
        InputFile.open(PATH);
        InputFile.splitData();
        InputFile.fillCountryHashtable();
        InputFile.fillSportHashtable();
        /*
        for (int i = 0; i < InputFile.ATHLETES.length; i++) {
            for (int j = 0; j < InputFile.ATHLETES[i].length; j++) {
                System.out.print(InputFile.ATHLETES[i][j] + " ");
            }
            System.out.println();
        }
        */
        
    }
}