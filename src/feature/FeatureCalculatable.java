package feature;

import java.util.List;

public interface FeatureCalculatable {

    CalculationResult calculateFeature(List<String> storedWords, List<String> storedSentences);
}
