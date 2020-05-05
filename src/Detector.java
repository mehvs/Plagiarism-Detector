import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

}
