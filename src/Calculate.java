package sizeyunsuan;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
	private static CreateRandom calculate1(CreateExpression expression, String symbol1, CreateRandom left1, CreateRandom right1) {
		String symbol = symbol1;
		CreateRandom left = left1;
		CreateRandom right = right1;
		switch (symbol) {
		case "+":
			return left.add(right);
		case "-"://�и�
			if (left.getDouble() <= right.getDouble()) {
				expression.isWrong = true;
				return new CreateRandom(1, 1);
			} else {
				return left.subtraction(right);
			}
		case "��":
			return left.multiplication(right);
		default:
			return left.division(right);
		}
	}

}
