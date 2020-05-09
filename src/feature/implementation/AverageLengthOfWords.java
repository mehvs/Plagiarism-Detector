package feature.implementation;

import feature.CalculationResult;
import feature.FeatureCalculatable;

import java.util.List;

public class AverageLengthOfWords implements FeatureCalculatable {

    private static final double WEIGHT = 11;

    @Override
    public CalculationResult calculateFeature(List<String> storedWords, List<String> storedSentences) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < storedWords.size(); i++) {
            sb.append(storedWords.get(i));
        }

        double result = (double) sb.length() / (double) storedWords.size();
        return new CalculationResult("  - Avg. word length: ", result, WEIGHT);
    }
}
