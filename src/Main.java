
public class Main {

    public static void main(String[] args) {
        InputFile.open();
        for(int i = 0; i<InputFile.METADATA.length; i++) {
            System.out.println(InputFile.METADATA[i]);
        }
    }
}
