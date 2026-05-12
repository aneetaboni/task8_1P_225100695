package web.service;

public class MathQuestionService {

	/**
	 * Calculate Q1 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q1Addition(String number1, String number2) {

		if (number1 == null || number2 == null ||
				number1.isEmpty() || number2.isEmpty()) {
			return Double.NaN;
		}

		try {
			double result =
					Double.valueOf(number1) + Double.valueOf(number2);

			return result;

		} catch (NumberFormatException e) {

			return Double.NaN;
		}
	}
	
	/**
	 * Calculate Q2 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q2Subtraction(String number1, String number2) {

		if (number1 == null || number2 == null ||
				number1.isEmpty() || number2.isEmpty()) {
			return Double.NaN;
		}

		try {
			double result =
					Double.valueOf(number1) - Double.valueOf(number2);

			return result;

		} catch (NumberFormatException e) {

			return Double.NaN;
		}
	}
	
	/**
	 * Calculate Q3 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q3Multiplication(String number1, String number2) {

	    if (number1 == null || number2 == null ||
	    		number1.isEmpty() || number2.isEmpty()) {

	        return Double.NaN;
	    }

	    try {

	        return Double.valueOf(number1) *
	        		Double.valueOf(number2);

	    } catch (NumberFormatException e) {

	        return Double.NaN;
	    }
	}
}