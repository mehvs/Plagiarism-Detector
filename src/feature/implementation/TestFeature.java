package feature.implementation;

import feature.CalculationResult;
import feature.FeatureCalculatable;

import java.util.List;

public class TestFeature implements FeatureCalculatable {

    @Override
    public CalculationResult calculateFeature(List<String> storedWords, List<String> storedSentences) {
        double result = (double) storedWords.size() + 12 / (double) storedSentences.size();
        return new CalculationResult("  - Test: ", result, 78);
    }
}
