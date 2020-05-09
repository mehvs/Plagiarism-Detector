package feature;

public class CalculationResult {

    private final double result;
    private final double weight;
    private final String calculationName;

    public CalculationResult(String calculationName, double result, double weight) {
        this.result = result;
        this.calculationName = calculationName;
        this.weight = weight;
    }

    public double calculateCategoryDifference(CalculationResult otherResult) {
        return Math.abs(result - otherResult.result) * weight;
    }

    @Override
    public String toString() {
        return calculationName + result;
    }
}
