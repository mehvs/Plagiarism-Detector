import feature.CalculationResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculationResultTest {

    private static final String RESULT_MESSAGE = "Test result: ";
    private static final double RESULT = 123.123;
    private static final double WEIGHT = 2.2;

    private CalculationResult calculationResult;

    @Before
    public void setup() {
        calculationResult = new CalculationResult(RESULT_MESSAGE, RESULT, WEIGHT);
    }

    @Test
    public void calculationResultString_ExpectSuccess() {
        String myResult = RESULT_MESSAGE + RESULT;
        Assert.assertEquals(calculationResult.toString(), myResult);
    }

    @Test
    public void calculationResultString_ExpectFailure() {
        String myResult = "RESULT_MESSAGE + RESULT";
        Assert.assertFalse("Messages should be different", calculationResult.toString().endsWith(myResult));
    }

    @Test
    public void CalculationResult_CalculateCategoryDifference_ShouldReturnZero() {
        CalculationResult other = new CalculationResult(RESULT_MESSAGE, RESULT, WEIGHT);
        double result = calculationResult.calculateCategoryDifference(other);

        Assert.assertEquals(0, result, 0);
    }

    @Test
    public void CalculationResult_CalculateCategoryDifference_ShouldReturnDifferentFromZero() {
        CalculationResult other = new CalculationResult("RESULT_MESSAGE", 23.64684, 68234);
        double result = calculationResult.calculateCategoryDifference(other);

        Assert.assertNotEquals(0, result, 0);

        Detector a = new Detector(null);
    }

    @Test
    public void CalculationResult_CalculateCategoryDifference_ShouldNotReturnNegativeValue() {
        CalculationResult other = new CalculationResult("RESULT_MESSAGE", 1223.64684, 68234);
        double result = calculationResult.calculateCategoryDifference(other);

        Assert.assertTrue("Calculation should not return negative value", result > 0);
    }

    @Test(expected = IllegalStateException.class)
    public void testException() {
        new Detector(null).test();
    }
}
