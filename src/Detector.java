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

}
