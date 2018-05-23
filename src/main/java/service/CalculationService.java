package service;

public class CalculationService implements Service{

	public Integer calc(Integer num1, Integer num2, String operation) {
		System.out.println(num1 + " " + num2 + " " + operation);
		Integer result = 0;
		if (operation.equals("+")) {
			result = num1 + num2;
		} else if (operation.equals("-")) {
			result = num1 - num2;
		} else if (operation.equals("*")) {
			result = num1 * num2;
		} else if (operation.equals("/")) {
			result = num1 / num2;
		}
		return result;
	}
}
