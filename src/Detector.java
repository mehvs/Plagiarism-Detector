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

    public void comparesTexts() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text one: ");
        textOne = input.nextLine();

        storedWordsOne = new ArrayList<>(Arrays.asList(textOne.split("([,.!?_;=+-:\\s]+)")));
        storedSentencesOne = new ArrayList<>(Arrays.asList(textOne.split("[!?.:]+")));

        System.out.println("1. Avg. word length: " + getAverageLengthOfWords(storedWordsOne) +
                "\n2. Type-Token Ratio: " + getTypeTokenRatio(storedWordsOne) +
                "\n3. Hapax Legomena Ratio: " + getHapaxLegomenaRatio(storedWordsOne) +
                "\n4. Avg. sentence length: " + getAverageWordsInSentence(storedWordsOne, storedSentencesOne));

        System.out.println("Enter text two: ");
        textTwo = input.nextLine();

        storedWordsTwo = new ArrayList<>(Arrays.asList(textTwo.split("([,.!?_;=+-:\\s]+)")));
        storedSentencesTwo = new ArrayList<>(Arrays.asList(textTwo.split("[!?.:]+")));

        System.out.println("1. Avg. word length: " + getAverageLengthOfWords(storedWordsTwo) +
                "\n2. Type-Token Ratio: " + getTypeTokenRatio(storedWordsTwo) +
                "\n3. Hapax Legomena Ratio: " + getHapaxLegomenaRatio(storedWordsTwo) +
                "\n4. Avg. sentence length: " + getAverageWordsInSentence(storedWordsTwo, storedSentencesTwo));

        double result = Math.abs(getAverageLengthOfWords(storedWordsOne) - getAverageLengthOfWords(storedWordsTwo)) * 11 +
                Math.abs(getTypeTokenRatio(storedWordsOne) - getTypeTokenRatio(storedWordsTwo)) * 33 +
                Math.abs(getHapaxLegomenaRatio(storedWordsOne) - getHapaxLegomenaRatio(storedWordsTwo)) * 50 +
                Math.abs(getAverageWordsInSentence(storedWordsOne, storedSentencesOne) - getAverageWordsInSentence(storedWordsTwo, storedSentencesTwo)) * 0.4;

        System.out.println("Similarity: " + result);


    }

}
