import feature.CalculationResult;
import feature.FeatureCalculatable;
import feature.implementation.AverageLengthOfWords;
import feature.implementation.AverageWordsInSentence;
import feature.implementation.HapaxLegomenaRatio;
import feature.implementation.TypeTokenRatio;

import java.util.*;

public class Detector {
    private Scanner input = new Scanner(System.in);

    private TypeTokenRatio typeTokenRatio = new TypeTokenRatio();
    private AverageLengthOfWords averageLengthOfWords = new AverageLengthOfWords();
    private HapaxLegomenaRatio hapaxLegomenaRatio = new HapaxLegomenaRatio();
    private AverageWordsInSentence averageWordsInSentence = new AverageWordsInSentence();

    private List<String> storedWordsOne;
    private List<String> storedWordsTwo;
    private List<String> storedSentencesOne;
    private List<String> storedSentencesTwo;

    private String textOne;
    private String textTwo;

    private double weightOne = 11;
    private double weightTwo = 33;
    private double weightThree = 50;
    private double weightFour = 0.4;

    private List<FeatureCalculatable> features;

    private List<CalculationResult> resultsOne;
    private List<CalculationResult> resultsTwo;

    public Detector(List<FeatureCalculatable> features) {
        this.features = features;
        resultsOne = new ArrayList<>();
        resultsTwo = new ArrayList<>();
    }

    public void detectTexts(String textOne, String textTwo) {
        storedWordsOne = getWordsFromText(textOne);
        storedWordsTwo = getWordsFromText(textTwo);

        storedSentencesOne = getSentencesFromText(textOne);
        storedSentencesTwo = getSentencesFromText(textTwo);

        resultsOne = calculateFeatures(storedWordsOne, storedSentencesOne);
        resultsTwo = calculateFeatures(storedWordsTwo, storedSentencesTwo);

        printsSimilarity();
    }

//    public double getTypeTokenRatio(List<String> storedWords) {
//        return typeTokenRatio.getsTypeTokenRatio(storedWords);
//    }
//
//    public double getAverageLengthOfWords(List<String> storedWords) {
//        return averageLengthOfWords.getsAverageLengthOfWords(storedWords);
//    }
//
//    public double getHapaxLegomenaRatio(List<String> storedWords) {
//        return hapaxLegomenaRatio.getsHapaxLegomenaRatio(storedWords);
//    }
//
//    public double getAverageWordsInSentence(List<String> storedWords, List<String> storedSentences) {
//        return averageWordsInSentence.getsAverageWordsInSentence(storedWords, storedSentences);
//    }

    public List<CalculationResult> calculateFeatures(List<String> storedWords, List<String> storedSentences) {
//        System.out.println("1. Avg. word length: " + getAverageLengthOfWords(storedWords) +
//                "\n2. Type-Token Ratio: " + getTypeTokenRatio(storedWords) +
//                "\n3. Hapax Legomena Ratio: " + getHapaxLegomenaRatio(storedWords) +
//                "\n4. Avg. sentence length: " + getAverageWordsInSentence(storedWords, storedSentences));
        List<CalculationResult> results = new ArrayList<>();
        for (FeatureCalculatable feature : features) {
            CalculationResult result = feature.calculateFeature(storedWords, storedSentences);
            System.out.println(result);

            results.add(result);
        }

        return results;
    }

    public void printsSimilarity() {
//        double result = Math.abs(getAverageLengthOfWords(storedWordsOne) - getAverageLengthOfWords(storedWordsTwo)) * weightOne +
//                Math.abs(getTypeTokenRatio(storedWordsOne) - getTypeTokenRatio(storedWordsTwo)) * weightTwo +
//                Math.abs(getHapaxLegomenaRatio(storedWordsOne) - getHapaxLegomenaRatio(storedWordsTwo)) * weightThree +
//                Math.abs(getAverageWordsInSentence(storedWordsOne, storedSentencesOne) - getAverageWordsInSentence(storedWordsTwo, storedSentencesTwo)) * weightFour;
        double result = 0;
        for (int i = 0; i < resultsOne.size(); i++) {
            result += resultsOne.get(i)
                    .calculateCategoryDifference(resultsTwo.get(i));
        }

        System.out.println("Similarity: " + result);
    }

    public void setsWeight() {
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

    public void storesTextOne() {
        System.out.print("Enter text one: ");
        textOne = input.nextLine();
        storedWordsOne = new ArrayList<>(Arrays.asList(textOne.split("([,.!?_;=+-:\\s]+)")));
        storedSentencesOne = new ArrayList<>(Arrays.asList(textOne.split("[!?.:]+")));
    }

    public void storesTextTwo() {
        System.out.print("Enter text two: ");
        textTwo = input.nextLine();
        storedWordsTwo = new ArrayList<>(Arrays.asList(textTwo.split("([,.!?_;=+-:\\s]+)")));
        storedSentencesTwo = new ArrayList<>(Arrays.asList(textTwo.split("[!?.:]+")));
    }

    public void comparesTexts() {
        storesTextOne();
        calculateFeatures(storedWordsOne, storedSentencesOne);
        storesTextTwo();
        calculateFeatures(storedWordsTwo, storedSentencesTwo);
        setsWeight();
        printsSimilarity();
    }

    private List<String> getWordsFromText(String text) {
        return new ArrayList<>(Arrays.asList(text.split("([,.!?_;=+-:\\s]+)")));
    }

    private List<String> getSentencesFromText(String text) {
        return new ArrayList<>(Arrays.asList(text.split("[!?.:]+")));
    }

    public void test() {


    }

}
