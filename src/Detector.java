import java.util.*;

public class Detector {

    public int countsUniqueWords(ArrayList<String> storedWords){
        Set<String> set = new HashSet<>();
        Set<String> common = new HashSet<>();
        for (String i : storedWords) {
            if(!set.add(i)) {
                common.add(i);
            }
        }
        return (set.size() - common.size());
    }

    public int countsDifferentWords(ArrayList<String> storedWords) {
        return (int) storedWords
                .stream()
                .distinct()
                .count();
    }

    //Gets the average length of words in a string (Feature 1)
    public double getsAverageLengthOfWords(ArrayList<String> storedWords) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < storedWords.size(); i++) {
            sb.append(storedWords.get(i));
        }
        return (double)sb.length() / (double)storedWords.size();
    }

    //Gets the TTR (Feature 2)
    public double getsTypeTokenRatio(ArrayList<String> storedWords){
        return (double)countsDifferentWords(storedWords)/(double)storedWords.size();
    }

    //Gets the HLR (Feature 3)
    public double getsHapaxLegomenaRatio(ArrayList<String> storedWords){
        return (double)countsUniqueWords(storedWords)/(double)storedWords.size();
    }

    //Gets the average words in sentences (Feature 4)
    public double getsAverageWordsInSentence(ArrayList<String> storedWords, ArrayList<String> storedSentences){
        return (double)storedWords.size()/(double)storedSentences.size();
    }

    public void comparesTexts(){
        ArrayList<String> storedWordsOne;
        ArrayList<String> storedWordsTwo;
        ArrayList<String> storedSentencesOne;
        ArrayList<String> storedSentencesTwo;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter text one: ");
        String textOne = input.nextLine();
        storedWordsOne = new ArrayList<>(Arrays.asList(textOne.split("([,.!?_;=+-:\\s]+)")));
        storedSentencesOne = new ArrayList<>(Arrays.asList(textOne.split("[!?.:]+")));

        double featureOneTextOne = getsAverageLengthOfWords(storedWordsOne);
        double featureTwoTextOne = getsTypeTokenRatio(storedWordsOne);
        double featureThreeTextOne = getsHapaxLegomenaRatio(storedWordsOne);
        double featureFourTextOne = getsAverageWordsInSentence(storedWordsOne, storedSentencesOne);

        System.out.println("1. Avg. word length: " + featureOneTextOne +
                "\n2. Type-Token Ratio: " + featureTwoTextOne +
                "\n3. Hapax Legomena Ratio: " + featureThreeTextOne +
                "\n4. Avg. sentence length: " + featureFourTextOne);

        System.out.print("Enter text two: ");
        String textTwo = input.nextLine();
        storedWordsTwo = new ArrayList<>(Arrays.asList(textTwo.split("([,.!?_;=+-:\\s]+)")));
        storedSentencesTwo = new ArrayList<>(Arrays.asList(textTwo.split("[!?.:]+")));

        double featureOneTextTwo = getsAverageLengthOfWords(storedWordsTwo);
        double featureTwoTextTwo = getsTypeTokenRatio(storedWordsTwo);
        double featureThreeTextTwo = getsHapaxLegomenaRatio(storedWordsTwo);
        double featureFourTextTwo = getsAverageWordsInSentence(storedWordsTwo, storedSentencesTwo);

        System.out.println("1. Avg. word length: " + featureOneTextTwo +
                "\n2. Type-Token Ratio: " + featureTwoTextTwo +
                "\n3. Hapax Legomena Ratio: " + featureThreeTextTwo +
                "\n4. Avg. sentence length: " + featureFourTextTwo);

        double result = Math.abs(featureOneTextOne - featureOneTextTwo) * 11 +
                Math.abs(featureTwoTextOne - featureTwoTextTwo) * 33 +
                Math.abs(featureThreeTextOne - featureThreeTextTwo) * 50 +
                Math.abs(featureFourTextOne - featureFourTextTwo) * 0.4;

        System.out.println("Similarity: " + result);


    }

}
