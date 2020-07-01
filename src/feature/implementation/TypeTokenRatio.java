package feature.implementation;

import feature.CalculationResult;
import feature.FeatureCalculatable;

import java.util.List;

public class TypeTokenRatio implements FeatureCalculatable {

    private static final double WEIGHT = 33;

    @Override
    public CalculationResult calculateFeature(List<String> storedWords, List<String> storedSentences) {
        double result = (double) countsDifferentWords(storedWords) / (double) storedWords.size();
        return new CalculationResult("  - Type-Token Ratio: ", result, WEIGHT);
    }

    private int countsDifferentWords(List<String> storedWords) {
        return (int) storedWords
                .stream()
                .distinct()
                .count();
    }
}
