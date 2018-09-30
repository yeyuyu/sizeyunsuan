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
		case "-"://判负
			if (left.getDouble() <= right.getDouble()) {
				expression.isWrong = true;
				return new CreateRandom(1, 1);
			} else {
				return left.subtraction(right);
			}
		case "×":
			return left.multiplication(right);
		default:
			return left.division(right);
		}
	}

	// 表达式结果计算方法
		public static String getResult(CreateExpression expression) {
			String string = expression.s;
			String[] strings = string.split("\\s+");
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < strings.length; i++) {
				list.add(strings[i]);
			}
			if (string.indexOf("(") != -1) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).equals("="))
						break;
					if (list.get(i).equals("(")) {
						list.set(i, calculate1(expression, list.get(i + 2), new CreateRandom(list.get(i + 1)), new CreateRandom(list.get(i + 3)))
								.toString());
						for (int j = 0; j < 4; j++) {
							list.remove(i + 1);
						}
					}
				}
			}//遇到括号时计算情况
			if (string.indexOf("×") != -1 || string.indexOf("÷") != -1) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).equals("="))
						break;
					if (list.get(i).equals("×") || list.get(i).equals("÷")) {
						list.set(i - 1, calculate1(expression, list.get(i), new CreateRandom(list.get(i - 1)), new CreateRandom(list.get(i + 1)))
								.toString());
						for (int j = 0; j < 2; j++) {
							list.remove(i);
						}
						i--;
					}
				}
			}
			if (string.indexOf("+") != -1 || string.indexOf("-") != -1) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).equals("="))
						break;
					if (list.get(i).equals("+") || list.get(i).equals("-")) {
						list.set(i - 1, calculate1(expression, list.get(i), new CreateRandom(list.get(i - 1)), new CreateRandom(list.get(i + 1)))
								.toString());
						for (int j = 0; j < 2; j++) {
							list.remove(i);
						}
						i--;
					}
				}
			}
			return list.get(0);
		}
		// 表达式计算
}
