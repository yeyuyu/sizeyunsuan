package sizeyunsuan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

//titleNum ��Ŀ����
//parameterRange ������Χ

public class OutPut {
	int titleNum;
	int parameterRange;
	Set<String> set = new HashSet<>();

	public OutPut() {//���췽��

	}

	public OutPut(int titleNum, int parameterRange) {
		this.titleNum = titleNum;
		this.parameterRange = parameterRange;
	}

	public void outputExercises() {
		try {
			PrintWriter exercisesWriter = new PrintWriter(new FileWriter("Exercises.txt"));//��������ָ���ļ������Ҳ����Զ���ˢ��
			PrintWriter answerWriter = new PrintWriter(new FileWriter("Answers.txt"));
			for (int i = 1; i < titleNum + 1;) {//������Ŀ����
				CreateExpression expression = new CreateExpression(parameterRange);
				String getresult = Calculate.getResult(expression);
				String string = getresult;
				System.out.println(expression.isWrong == false);
				System.out.println(!(set.contains(string)));
				if (expression.isWrong == false  && !(set.contains(string))) {
					set.add(string);
					exercisesWriter.println(i + ". " + expression.toString());
					answerWriter.println((i + ". " + string));
					i++;
				}
			}
			exercisesWriter.close();
			answerWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("�Ѿ�������Ŀ�ʹ�");
	}


// exercisePath  ���ʽ�ļ�·��
// answerPath  ����ļ�·
// gradePath  �������ļ�·��
	
	
	
}
