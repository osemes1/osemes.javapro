package match_basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicMathTest {

    @Test
    public void testAdd() {
        double result = BasicMath.add(5, 7);
        Assertions.assertEquals(12, result);
    }

    @Test
    public void testSubtract() {
        double result = BasicMath.subtract(10, 3);
        Assertions.assertEquals(7, result);
    }

    @Test
    public void testMultiply() {
        double result = BasicMath.multiply(2, 5);
        Assertions.assertEquals(10, result);
    }

    @Test
    public void testDivide() {
        double result = BasicMath.divide(15, 3);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> BasicMath.divide(10, 0));
    }

    @Test
    public void testPower() {
        double result = BasicMath.power(2, 3);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testSquareRoot() {
        double result = BasicMath.squareRoot(16);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void testSquareRootNegativeNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> BasicMath.squareRoot(-4));
    }

    @Test
    public void testAbsoluteValuePositiveNumber() {
        double result = BasicMath.absoluteValue(7);
        Assertions.assertEquals(7, result);
    }

    @Test
    public void testAbsoluteValueNegativeNumber() {
        double result = BasicMath.absoluteValue(-7);
        Assertions.assertEquals(7, result);
    }
}
