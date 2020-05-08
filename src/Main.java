import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean detectorIsOn = true;
        Scanner input = new Scanner(System.in);
        Detector detector = new Detector();

        while (detectorIsOn) {
            detector.comparesTexts();

            System.out.print("Type 1 if you want to compare new texts or type 2 to exit the detector: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    detectorIsOn = true;
                    break;
                case 2:
                    detectorIsOn = false;
                    break;
            }


        }
    }
}
