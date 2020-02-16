
public class Main {

    static String PATH;

    public static void main(String[] args) {
        PATH = "/home/ozan/Downloads/input.txt";
        InputFile.splitData();
        for (int i = 0; i < InputFile.ATHLETES.length; i++) {
            for(int j = 0; j<InputFile.ATHLETES[i].length; j++){
                System.out.print(InputFile.ATHLETES[i][j]+" ");
            }
            System.out.println();
        }
    }
}