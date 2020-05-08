import java.util.ArrayList;

public class AverageWordsInSentence {

    public double getsAverageWordsInSentence(ArrayList<String> storedWords, ArrayList<String> storedSentences) {
        return (double) storedWords.size() / (double) storedSentences.size();
    }

}
