import java.util.ArrayList;

public class AverageLengthOfWords {
    public double getsAverageLengthOfWords(ArrayList<String> storedWords) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < storedWords.size(); i++) {
            sb.append(storedWords.get(i));
        }
        return (double)sb.length() / (double)storedWords.size();
    }

}
