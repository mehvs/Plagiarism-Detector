import java.util.*;

public class Detector {

    TypeTokenRatio typeTokenRatio = new TypeTokenRatio();
    AverageLengthOfWords averageLengthOfWords = new AverageLengthOfWords();
    HapaxLegomenaRatio hapaxLegomenaRatio = new HapaxLegomenaRatio();
    AverageWordsInSentence averageWordsInSentence = new AverageWordsInSentence();

    private ArrayList<String> storedWordsOne;
    private ArrayList<String> storedWordsTwo;
    private ArrayList<String> storedSentencesOne;
    private ArrayList<String> storedSentencesTwo;

    private String textOne;
    private String textTwo;

    private double weightOne = 11;
    private double weightTwo = 33;
    private double weightThree = 50;
    private double weightFour = 0.4;

    public double getTypeTokenRatio(ArrayList<String> storedWords) {
        return typeTokenRatio.getsTypeTokenRatio(storedWords);
    }

    public double getAverageLengthOfWords(ArrayList<String> storedWords) {
        return averageLengthOfWords.getsAverageLengthOfWords(storedWords);
    }

    public double getHapaxLegomenaRatio(ArrayList<String> storedWords) {
        return hapaxLegomenaRatio.getsHapaxLegomenaRatio(storedWords);
    }

    public double getAverageWordsInSentence(ArrayList<String> storedWords, ArrayList<String> storedSentences) {
        return averageWordsInSentence.getsAverageWordsInSentence(storedWords, storedSentences);
    }

    public void printsResult(ArrayList<String> storedWords, ArrayList<String> storedSentences) {
        System.out.println("1. Avg. word length: " + getAverageLengthOfWords(storedWords) +
                "\n2. Type-Token Ratio: " + getTypeTokenRatio(storedWords) +
                "\n3. Hapax Legomena Ratio: " + getHapaxLegomenaRatio(storedWords) +
                "\n4. Avg. sentence length: " + getAverageWordsInSentence(storedWords, storedSentences));
    }

    public void printsSimilarity() {
        double result = Math.abs(getAverageLengthOfWords(storedWordsOne) - getAverageLengthOfWords(storedWordsTwo)) * weightOne +
                Math.abs(getTypeTokenRatio(storedWordsOne) - getTypeTokenRatio(storedWordsTwo)) * weightTwo +
                Math.abs(getHapaxLegomenaRatio(storedWordsOne) - getHapaxLegomenaRatio(storedWordsTwo)) * weightThree +
                Math.abs(getAverageWordsInSentence(storedWordsOne, storedSentencesOne) - getAverageWordsInSentence(storedWordsTwo, storedSentencesTwo)) * weightFour;

        System.out.println("Similarity: " + result);
    }

    public void setsWeight() {
        Scanner input = new Scanner(System.in);
        System.out.print("Type 1 if you want to continue with default values(Default values: 11, 33, 50, 0.4), type 2 to set your own values: ");

        int option = input.nextInt();

        switch (option) {
            case 1:
                break;
            case 2:
                weightOne = input.nextDouble();
                weightTwo = input.nextDouble();
                weightThree = input.nextDouble();
                weightFour = input.nextDouble();
                break;
        }
    }

    public void comparesTexts() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text one: ");
        textOne = input.nextLine();

        storedWordsOne = new ArrayList<>(Arrays.asList(textOne.split("([,.!?_;=+-:\\s]+)")));
        storedSentencesOne = new ArrayList<>(Arrays.asList(textOne.split("[!?.:]+")));

        printsResult(storedWordsOne, storedSentencesOne);

        System.out.print("Enter text two: ");
        textTwo = input.nextLine();

        storedWordsTwo = new ArrayList<>(Arrays.asList(textTwo.split("([,.!?_;=+-:\\s]+)")));
        storedSentencesTwo = new ArrayList<>(Arrays.asList(textTwo.split("[!?.:]+")));

        printsResult(storedWordsTwo, storedSentencesTwo);

        setsWeight();
        printsSimilarity();


    }

}
