
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void printFixture() {

    }
    public static void printTournaments() {

    }
    public static void printStatistics() {

    }

    public static void Primary() {
        System.out.println("******MENU******");
        System.out.println("1- Generate Fixture");
        System.out.println("2- Perform Tournaments");
        System.out.println("3- Show Statistics");
        String ans = sc.nextLine();

        if(ans.equals("1")) {
            printFixture();
        }
        else if(ans.equals("2")) {
            printTournaments();
        }
        else if(ans.equals("3")){
            printStatistics();
        }
    }
}