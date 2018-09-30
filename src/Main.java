package sizeyunsuan;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		int titleNum; // 定义题目个数
		int parameterRange; // 定义参数范围
		System.out.println("************************************************************");
		System.out.println("-n控制生成题目数量；-r控制题目中的数值范围；-e判断答案是否正确并进行数量统计。格式如下： ");
		System.out.println("-n 题目数量");
		System.out.println("-r 数值范围");// 使用 -n 参数控制生成题目的个数
		System.out.println("-e 题目路径  答案路径");// 对给定的题目文件和答案文件，判定答案中的对错并进行数量统计
		System.out.println("************************************************************");
		System.out.println("请输入命令：");
		Scanner s1 = new Scanner(System.in);
		String m = s1.nextLine();
		String str[] = m.split("\\s");//分割输入的字符串，存入数组
		switch (str[0]) {
		case "-n":
			titleNum = Integer.valueOf(str[1].toString());
			System.out.println("请输入-r命令：");
			Scanner s2= new Scanner(System.in);
			String n = s2.nextLine();
			String strr[] = n.split("\\s");//以单词划分
			if (strr[0].equals("-r")) {
				parameterRange = Integer.valueOf(strr[1].toString());
				OutPut function = new OutPut(titleNum, parameterRange);
				function.outputExercises();
				break;
			} else {
				System.out.println("该命令不存在或格式错误!");
				break;
			}
		case "-e":
			OutPut function0 = new OutPut();
			String gradePath = "Grade.txt";
			function0.outputGrade(str[1], str[2], gradePath);
			break;
		default:
			System.out.println("该命令不存在或格式错误!");
			break;
		}
		s1.close();
	}
	}

