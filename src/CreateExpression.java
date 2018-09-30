//叶湖倩
package sizeyunsuan;

import java.util.concurrent.ThreadLocalRandom;

public class CreateExpression {
	int parameterRange;
	char[] symbol = { '+', '-', '×', '÷' };
	public boolean isWrong = false;
	public String s;
	ThreadLocalRandom random = ThreadLocalRandom.current();

    public CreateExpression(String string) {
    	s=string.trim();
    	expreGenerate(s);
    }

	public CreateExpression(int parameterRange) {//生成表达式
		super();
		this.parameterRange = parameterRange;
		int n = random.nextInt(1, 4);
		char[] symchar = new char[n];
		char[] symchar1 = new char[n];
		for (int i = 0; i < n; i++) {
			int j = random.nextInt(0, 4);
			symchar[i] = symbol[j];
		}
		for (int i = 0; i < n; i++) {
			if (symchar[i] == '+' || symchar[i] == '-') {
				symchar1[i] = '1';
			}
			if (symchar[i] == '×' || symchar[i] == '÷') {
				symchar1[i] = '2';
			}
		}
		String string = symchar1.toString().trim();
		if (n == 1) {
			String[] str0 = new String[4];
			str0[0] = createFraction().toString();
			str0[1] = String.valueOf(symchar[0]);
			str0[2] = createFraction().toString();
			str0[3] = "=";
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < 4; i++) {
				stringBuffer = stringBuffer.append(str0[i] + " ");//生成表达式
			}
			s = stringBuffer.toString();
		} else if (n == 2) {
			if (string == "12" || string == "22") {
				Object[] str1 = new String[6];
				str1[0] = createFraction().toString();
				str1[1] = String.valueOf(symchar[0]);
				str1[2] = createFraction().toString();
				str1[3] = String.valueOf(symchar[1]);
				str1[4] = createFraction().toString();
				str1[5] = "=";
				StringBuffer stringBuffer = new StringBuffer();
				for (int i = 0; i < 6; i++) {
					stringBuffer = stringBuffer.append(str1[i] + " ");
				}
				s = stringBuffer.toString();
			} else {
				String[] str2 = new String[8];
				str2[0] = createFraction().toString();
				str2[1] = String.valueOf(symchar[0]);
				str2[2] = "(";
				str2[3] = createFraction().toString();
				str2[4] = String.valueOf(symchar[1]);
				str2[5] = createFraction().toString();
				str2[6] = ")";
				str2[7] = "=";
				StringBuffer stringBuffer = new StringBuffer();
				for (int i = 0; i < 8; i++) {
					stringBuffer = stringBuffer.append(str2[i] + " ");
				}
				s = stringBuffer.toString();
			}
		} else {
			if (string == "221" || string == "222") {
				String[] str3 = new String[10];
				str3[0] = createFraction().toString();
				str3[1] = String.valueOf(symchar[0]);
				str3[2] = createFraction().toString();
				str3[3] = String.valueOf(symchar[1]);
				str3[4] = "(";
				str3[5] = createFraction().toString();
				str3[6] = String.valueOf(symchar[2]);
				str3[7] = createFraction().toString();
				str3[8] = ")";
				str3[9] = "=";
				StringBuffer stringBuffer = new StringBuffer();
				for (int i = 0; i < 10; i++) {
					stringBuffer = stringBuffer.append(str3[i] + " ");
				}
				s = stringBuffer.toString().trim();

			} else if (string == "111" || string == "112") {
				Object[] str4 = new String[10];
				str4[0] = createFraction().toString();
				str4[1] = String.valueOf(symchar[0]);
				str4[2] = "(";
				str4[3] = createFraction().toString();
				str4[4] = String.valueOf(symchar[1]);
				str4[5] = createFraction().toString();
				str4[6] = ")";
				str4[7] = String.valueOf(symchar[2]);
				str4[8] = createFraction().toString();
				str4[9] = "=";
				StringBuffer stringBuffer = new StringBuffer();
				for (int i = 0; i < 10; i++) {
					stringBuffer = stringBuffer.append(str4[i] + " ");
				}
				s = stringBuffer.toString().trim();
			} else if (string == "121" || string == "122") {
				Object[] str5 = new String[10];
				str5[0] = "(";
				str5[1] = createFraction().toString();
				str5[2] = String.valueOf(symchar[0]);
				str5[3] = createFraction().toString();
				str5[4] = ")";
				str5[5] = String.valueOf(symchar[1]);
				str5[6] = createFraction().toString();
				str5[7] = String.valueOf(symchar[2]);
				str5[8] = createFraction().toString();
				str5[9] = "=";
				StringBuffer stringBuffer = new StringBuffer();
				for (int i = 0; i < 10; i++) {
					stringBuffer = stringBuffer.append(str5[i] + " ");
				}
				s = stringBuffer.toString().trim();
			} else {
				Object[] str6 = new String[8];
				str6[0] = createFraction().toString();
				str6[1] = String.valueOf(symchar[0]);
				str6[2] = createFraction().toString();
				str6[3] = String.valueOf(symchar[1]);
				str6[4] = createFraction().toString();
				str6[5] = String.valueOf(symchar[2]);
				str6[6] = createFraction().toString();
				str6[7] = "=";
				StringBuffer stringBuffer = new StringBuffer();
				for (int i = 0; i < 8; i++) {
					stringBuffer = stringBuffer.append(str6[i] + " ");
				}
				s = stringBuffer.toString().trim();
			}
		}
		expreGenerate(s);
	}

	// 随机生成一个分数
	CreateRandom createFraction() {
		return new CreateRandom(random.nextInt(1, parameterRange), random.nextInt(1, 10));
	}

	// 返回一个表达式
	private String expreGenerate(String s) {
		return s;
	}

	public String toString() {
		return s;
	}
}

