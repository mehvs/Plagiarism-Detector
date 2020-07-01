import java.util.Scanner;

public class UserInputOutput {

    private Scanner scanner;

    public UserInputOutput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readNextInt() {
        return scanner.nextInt();
    }

    public double readNextDouble() {
        return scanner.nextDouble();
    }

    public String readNextLine() {
        return scanner.nextLine();
    }

    public void printEndOptions() {
        System.out.print("Type 1 if you want to compare new texts or type 2 to exit the detector: ");
    }
}
