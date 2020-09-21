package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	// 일반적으로 선호되는 위치
	@Autowired(required = true)	// 기본생성자를 생성하면서 인젝션 됨
	//@Qualifier("exam2")	// 객체가 2개이상 있어서 식별이 모호할 경우 선택할수 있다.
	private Exam exam;
	
	public InlineExamConsole() {
		System.out.println("constructor");
	}
	
	public InlineExamConsole(Exam exam) {
		System.out.println("overloaded constructor");
		this.exam = exam;
	}



	@Override
	public void print() {
		if (exam == null)
			System.out.printf("total is %d avg is %f\n", 0 , 0.0);
		else
		System.out.printf("total is %d avg is %f\n",exam.total(),exam.avg());
	}

//	@Autowired	// 자동으로 객체를 연결
//	@Qualifier("exam2")	// 객체가 2개이상 있어서 식별이 모호할 경우 선택할수 있다.
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}
}
