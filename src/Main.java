package sizeyunsuan;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		int titleNum; // ������Ŀ����
		int parameterRange; // ���������Χ
		System.out.println("************************************************************");
		System.out.println("-n����������Ŀ������-r������Ŀ�е���ֵ��Χ��-e�жϴ��Ƿ���ȷ����������ͳ�ơ���ʽ���£� ");
		System.out.println("-n ��Ŀ����");
		System.out.println("-r ��ֵ��Χ");// ʹ�� -n ��������������Ŀ�ĸ���
		System.out.println("-e ��Ŀ·��  ��·��");// �Ը�������Ŀ�ļ��ʹ��ļ����ж����еĶԴ���������ͳ��
		System.out.println("************************************************************");
		System.out.println("���������");
		Scanner s1 = new Scanner(System.in);
		String m = s1.nextLine();
		String str[] = m.split("\\s");//�ָ�������ַ�������������
		switch (str[0]) {
		case "-n":
			titleNum = Integer.valueOf(str[1].toString());
			System.out.println("������-r���");
			Scanner s2= new Scanner(System.in);
			String n = s2.nextLine();
			String strr[] = n.split("\\s");//�Ե��ʻ���
			if (strr[0].equals("-r")) {
				parameterRange = Integer.valueOf(strr[1].toString());
				OutPut function = new OutPut(titleNum, parameterRange);
				function.outputExercises();
				break;
			} else {
				System.out.println("��������ڻ��ʽ����!");
				break;
			}
		case "-e":
			OutPut function0 = new OutPut();
			String gradePath = "Grade.txt";
			function0.outputGrade(str[1], str[2], gradePath);
			break;
		default:
			System.out.println("��������ڻ��ʽ����!");
			break;
		}
		s1.close();
	}
	}

