//Ҷ����
package sizeyunsuan;

public class CreateRandom {

	private int a; // �������
	private int b; // �����ĸ

	public CreateRandom(String string) { // �����ֵ��ַ�����ʽת��Ϊ������������ʽ
		string = string.trim(); // ���ǰ��ո�
		int c = string.indexOf("'"); // ���������־��'��������
		int d = string.indexOf("/"); // �������־��/��������
		if (c != -1) { // ����Ϊ������
			int z = Integer.valueOf(string.substring(0, c));//�ַ����Ӵ�
			b = Integer.valueOf(string.substring(d + 1));//ȡ��ĸ
			a = z * b + Integer.valueOf(string.substring(c + 1, d));//ȡ����
		} else if (d != -1) { // ����Ϊ�����
			b = Integer.valueOf(string.substring(d + 1));
			a = Integer.valueOf(string.substring(0, d));
		} else { // ����Ϊ����
			a = Integer.valueOf(string);
			b = 1;
		}
		build(a, b);//����
	}

	public CreateRandom(int a, int b) {
		build(a, b);
	}

	// ������ʽת��Ϊ�ַ�����ʽ
	public String toString() {
		if (b == 1) {
			return String.valueOf(a);
		} else {
			int i = a / b;
			if (i != 0) {
				return String.format("%d'%d/%d", i, a - b * i, b);
			} else {
				return String.format("%d/%d", a, b);
			}
		}
	}

	// �������ӷ�ĸ�������               ����
	private void build(int a, int b) {
		if (b == 0) {
			throw new RuntimeException("��ĸ����Ϊ0");
		}
		int c = comfactor(a, b);
		this.a = a / c;
		this.b = b / c;
	}

	// ������
	private int comfactor(int a, int b) {
		int mod = a % b;
		return mod == 0 ? b : comfactor(b, mod);
	}

	// �ӷ� a + b
	public CreateRandom add(CreateRandom fraction) {
		return new CreateRandom(this.a * fraction.b + fraction.a * this.b, this.b * fraction.b);
	}//1/4+1/3

	// ���� a - b
	public CreateRandom subtraction(CreateRandom fraction) {
		return new CreateRandom(this.a * fraction.b - fraction.a * this.b, this.b * fraction.b);
	}

	// �˷� a x b
	public CreateRandom multiplication(CreateRandom fraction) {
		return new CreateRandom(this.a * fraction.a, this.b * fraction.b);
	}

	// ����a/b
	public CreateRandom division(CreateRandom fraction) {
		return new CreateRandom(this.a * fraction.b, b * fraction.a);
	}

public double getDouble() {
		return a / b;
	}
}