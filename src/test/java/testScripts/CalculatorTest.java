package testScripts;

import org.qa.framework.tdd.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    @Test
    public void addTwoPositiveNumbers()
    {
        int expectedResult = 30;
        int ActuaResult = Calculator.addNumbers(10,20);
        Assert.assertEquals(expectedResult, ActuaResult);
    }

    @Test
    public void addTwoNegativeNumbers()
    {
        int expectedResult = -30;
        int ActuaResult = Calculator.addNumbers(-10, -20);
        Assert.assertEquals(expectedResult, ActuaResult);
    }

    @Test
    public void multiplyTwoPositiveNumbers()
    {
        int expectedResult = 200;
        int ActualResult = Calculator.multiplyNumbers(10,20);
        Assert.assertEquals(expectedResult, ActualResult);
    }

    @Test
    public void multiplyTwoNegativeNumbers()
    {
        int expectedResult = 200;
        int ActualResult = Calculator.multiplyNumbers(-10, -20);
        Assert.assertEquals(expectedResult, ActualResult);
    }
}
