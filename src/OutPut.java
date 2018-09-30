package sizeyunsuan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

//titleNum 题目个数
//parameterRange 参数范围

public class OutPut {
	int titleNum;
	int parameterRange;
	Set<String> set = new HashSet<>();

	public OutPut() {//构造方法

	}

	public OutPut(int titleNum, int parameterRange) {
		this.titleNum = titleNum;
		this.parameterRange = parameterRange;
	}

	public void outputExercises() {
		try {
			PrintWriter exercisesWriter = new PrintWriter(new FileWriter("Exercises.txt"));//创建具有指定文件名称且不带自动行刷新
			PrintWriter answerWriter = new PrintWriter(new FileWriter("Answers.txt"));
			for (int i = 1; i < titleNum + 1;) {//控制题目数量
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
		System.out.println("已经生成题目和答案");
	}


// exercisePath  表达式文件路径
// answerPath  结果文件路
// gradePath  输出结果文件路径
	
	
	public void outputGrade(String exercisePath, String answerPath, String gradePath) {

		try {
			BufferedReader exercisesReader = new BufferedReader(new FileReader(exercisePath));
			BufferedReader answerReader = new BufferedReader(new FileReader(answerPath));
			PrintWriter gradeWriter = new PrintWriter(new FileWriter(gradePath));
			String exercises, answer;
			int c = 0, w = 0;
			StringBuilder correct = new StringBuilder("Correct: %d (");
			StringBuilder wrong = new StringBuilder("Wrong: %d (");
			while ((exercises = exercisesReader.readLine()) != null && (answer = answerReader.readLine()) != null) {
				int exercisesPoint = exercises.indexOf(".");//索引
				int answerPoint = answer.indexOf(".");
				if (exercisesPoint != -1 && answerPoint != -1) {
					int i = Integer.valueOf(exercises.substring(0, exercisesPoint).trim());
					CreateExpression expression = new CreateExpression(exercises.substring(exercisesPoint + 1));
					CreateRandom ans = new CreateRandom(answer.substring(answerPoint + 1));
					String getresult = Calculate.getResult(expression);
					String string = getresult;
					if (string.equals(ans.toString())) {
						c++;
						correct.append(" " + i);
						if (c % 30 == 0) {
							correct.append("\r\n");
						}
					} else {
						w++;
						wrong.append(" " + i);
						if (w % 30 == 0) {
							wrong.append("-r\n");
						}
					}
				}
			}
			gradeWriter.println(String.format(correct.append(" )").toString(), c));
			gradeWriter.println(String.format(wrong.append(" )").toString(), w));
			gradeWriter.flush();
			exercisesReader.close();
			answerReader.close();
			gradeWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("已经比较完成，并生成输出文件");
	}
}
