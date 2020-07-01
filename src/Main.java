import feature.FeatureCalculatable;
import feature.implementation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean detectorIsOn = true;
        List<FeatureCalculatable> features = Arrays.asList(new TypeTokenRatio(), new HapaxLegomenaRatio(), new AverageLengthOfWords(), new AverageWordsInSentence());
//        List<FeatureCalculatable> features = Arrays.asList(new TypeTokenRatio(), new HapaxLegomenaRatio(), new AverageLengthOfWords(), new AverageWordsInSentence(), new TestFeature());
        Detector detector = new Detector(features);
        UserInputOutput inputOutput = new UserInputOutput(new Scanner(System.in));

        while (detectorIsOn) {
            String textOne = inputOutput.readNextLine();
            String textTwo = inputOutput.readNextLine();

            detector.detectTexts(textOne, textTwo);

            inputOutput.printEndOptions();
            int option = inputOutput.readNextInt();

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
