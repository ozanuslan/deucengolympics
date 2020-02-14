
public class Main {

    static String PATH;

    public static void main(String[] args) {
        PATH = "/home/ozan/Downloads/input.txt";
        InputFile.open(PATH);
        for (int i = 0; i < InputFile.METADATA.length; i++) {
            System.out.println(InputFile.METADATA[i]);
        }
    }
}