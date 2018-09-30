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
	
	
	
}
