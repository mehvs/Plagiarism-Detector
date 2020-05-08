import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HapaxLegomenaRatio {

    public int countsUniqueWords(ArrayList<String> storedWords) {
        Set<String> set = new HashSet<>();
        Set<String> common = new HashSet<>();
        for (String i : storedWords) {
            if (!set.add(i)) {
                common.add(i);
            }
        }
        return (set.size() - common.size());
    }

    public double getsHapaxLegomenaRatio(ArrayList<String> storedWords) {
        return (double) countsUniqueWords(storedWords) / (double) storedWords.size();
    }
}
