
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    private void printFixture() {
        for(int i = 0; i<Main.olympiad.TOURNAMENTS.length; i++){
            System.out.println(Main.olympiad.TOURNAMENTS[i].sport.sport+" Fixture");
            for(int j = 0; j<Main.olympiad.TOURNAMENTS[i].MATCHES.length; j++){
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.day+".");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.month+".");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.year+" ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.hour+":");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.min+" ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.country+"-");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.name+" vs. ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.country+"-");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.name+"  ");
                System.out.println();
            }
            System.out.println();
        }
    }

    private void printTournaments() {
        for(int i = 0; i<Main.olympiad.TOURNAMENTS.length; i++){
            System.out.println(Main.olympiad.TOURNAMENTS[i].sport.sport+" Matches");
            for(int j = 0; j<Main.olympiad.TOURNAMENTS[i].MATCHES.length; j++){
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.day+".");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.month+".");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.year+" ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.hour+":");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].date.min+" ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.country+"-");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath1.name+" vs. ");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.country+"-");
                System.out.print(Main.olympiad.TOURNAMENTS[i].MATCHES[j].ath2.name+"  ");
                System.out.println("Winner: "+Main.olympiad.TOURNAMENTS[i].MATCHES[j].winner);
            }
            System.out.println();
        }
    }

    private void showStatistics() {
        showSecondaryMenu();
    }

    public void showPrimaryMenu() {
        System.out.println("*****MENU*****");
        System.out.println("1- Generate Fixture");
        System.out.println("2- Perform Tournaments");
        System.out.println("3- Show Statistics");
        String ans = "";
        boolean isLegal = false;
        while (!isLegal) {
            ans = sc.nextLine();
            if (ans.equals("1") || ans.equals("2") || ans.equals("3")) {
                isLegal = true;
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
        
    }

    public void showSecondaryMenu() {
        System.out.println("***** STATISTICS MENU *****");
        System.out.println("1- The country with the highest score");
        System.out.println("2- The athlete with the highest score");
        System.out.println("3- List of matches by date");
        System.out.println("4- List of matches by country");

        String ans = "";
        boolean isLegal = false;
        while (!isLegal) {
            ans = sc.nextLine();
            if (ans.equals("1") || ans.equals("2") || ans.equals("3") || ans.equals("4")) {
                isLegal = true;
            }
        }
        /*
         * todo: add menu options
         */
    }

    public void printCountryWithHighestScore(){
    
    }
}