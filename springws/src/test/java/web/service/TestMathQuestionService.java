package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

	@Test
	public void testTrueAdd() {
		Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0.001);
	}
	@Test
	public void testWrongAddition() {
	    MathQuestionService service = new MathQuestionService();
	    assertEquals(999, service.q1Addition("1", "1"));
	}

	@Test
	public void testAddNumber1Empty() {
		double result = MathQuestionService.q1Addition("", "2");
		Assert.assertTrue(Double.isNaN(result));
	}

	@Test
	public void testQ3MultiplicationCorrectValues() {
		double result = MathQuestionService.q3Multiplication("4", "5");
		Assert.assertEquals(20.0, result, 0.001);
	}

	@Test
	public void testQ3MultiplicationWithDecimalValues() {
		double result = MathQuestionService.q3Multiplication("2.5", "4");
		Assert.assertEquals(10.0, result, 0.001);
	}

	@Test
	public void testQ3MultiplicationWithEmptyInput() {
		double result = MathQuestionService.q3Multiplication("", "4");
		Assert.assertTrue(Double.isNaN(result));
	}

	@Test
	public void testQ3MultiplicationWithInvalidInput() {
		double result = MathQuestionService.q3Multiplication("abc", "4");
		Assert.assertTrue(Double.isNaN(result));
	}
}