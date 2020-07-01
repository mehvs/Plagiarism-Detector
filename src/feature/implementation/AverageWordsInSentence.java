package feature.implementation;

import feature.CalculationResult;
import feature.FeatureCalculatable;

import java.util.List;

public class AverageWordsInSentence implements FeatureCalculatable {

    private static final double WEIGHT = 0.4;

    @Override
    public CalculationResult calculateFeature(List<String> storedWords, List<String> storedSentences) {
        double result = (double) storedWords.size() / (double) storedSentences.size();
        return new CalculationResult("  - Avg. sentence length: ", result, WEIGHT);
    }
}
