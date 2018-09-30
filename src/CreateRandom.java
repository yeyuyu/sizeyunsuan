//叶钰羽
package sizeyunsuan;

public class CreateRandom {

	private int a; // 定义分子
	private int b; // 定义分母

	public CreateRandom(String string) { // 将数字的字符串形式转换为整数、分数形式
		string = string.trim(); // 清除前后空格
		int c = string.indexOf("'"); // 求带分数标志“'”的索引
		int d = string.indexOf("/"); // 求分数标志“/”的索引
		if (c != -1) { // 数字为带分数
			int z = Integer.valueOf(string.substring(0, c));//字符串子串
			b = Integer.valueOf(string.substring(d + 1));//取分母
			a = z * b + Integer.valueOf(string.substring(c + 1, d));//取分子
		} else if (d != -1) { // 数字为真分数
			b = Integer.valueOf(string.substring(d + 1));
			a = Integer.valueOf(string.substring(0, d));
		} else { // 数字为整数
			a = Integer.valueOf(string);
			b = 1;
		}
		build(a, b);//化简
	}

	public CreateRandom(int a, int b) {
		build(a, b);
	}

	// 数字形式转换为字符串形式
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

	// 给定分子分母构造分数               化简
	private void build(int a, int b) {
		if (b == 0) {
			throw new RuntimeException("分母不能为0");
		}
		int c = comfactor(a, b);
		this.a = a / c;
		this.b = b / c;
	}

	// 求公因子
	private int comfactor(int a, int b) {
		int mod = a % b;
		return mod == 0 ? b : comfactor(b, mod);
	}

	// 加法 a + b
	public CreateRandom add(CreateRandom fraction) {
		return new CreateRandom(this.a * fraction.b + fraction.a * this.b, this.b * fraction.b);
	}//1/4+1/3

	// 减法 a - b
	public CreateRandom subtraction(CreateRandom fraction) {
		return new CreateRandom(this.a * fraction.b - fraction.a * this.b, this.b * fraction.b);
	}

	// 乘法 a x b
	public CreateRandom multiplication(CreateRandom fraction) {
		return new CreateRandom(this.a * fraction.a, this.b * fraction.b);
	}

	// 除法a/b
	public CreateRandom division(CreateRandom fraction) {
		return new CreateRandom(this.a * fraction.b, b * fraction.a);
	}

public double getDouble() {
		return a / b;
	}
}