import java.util.ArrayList;

public class TypeTokenRatio {

    public int countsDifferentWords(ArrayList<String> storedWords) {
        return (int) storedWords
                .stream()
                .distinct()
                .count();
    }

    public double getsTypeTokenRatio(ArrayList<String> storedWords) {
        return (double) countsDifferentWords(storedWords) / (double) storedWords.size();
    }

}
