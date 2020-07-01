package feature.implementation;

import feature.CalculationResult;
import feature.FeatureCalculatable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HapaxLegomenaRatio implements FeatureCalculatable {

    private static final double WEIGHT = 50;

    @Override
    public CalculationResult calculateFeature(List<String> storedWords, List<String> storedSentences) {
        double result = (double) countsUniqueWords(storedWords) / (double) storedWords.size();
        return new CalculationResult("  - Hapax Legomena Ratio: ", result, WEIGHT);
    }

    private int countsUniqueWords(List<String> storedWords) {
        Set<String> set = new HashSet<>();
        Set<String> common = new HashSet<>();
        for (String i : storedWords) {
            if (!set.add(i)) {
                common.add(i);
            }
        }
        return (set.size() - common.size());
    }
}
