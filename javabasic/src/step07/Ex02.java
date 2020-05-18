package step07;

import java.util.Random;
import java.util.Scanner;

//# 학생성적관리 프로그램(2단계)[문제]

class Student{
	int hakbun;
	int score;
}

class StudentMng{
	
	void test1(int[] x) { //scores배열에 1~100점 사이의 정수를 5개 저장 메서드
		Random rnd = new Random(); 
		for(int i = 0; i < x.length; i++) {
			x[i] = rnd.nextInt(100) + 1;
			System.out.print(x[i] + " ");
		}
		System.out.println("");
	}
	
	int test2(int[] x) {// 문제2) 전교생의 총점 리턴 메서드
		int sum = 0;
		for(int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum;
	}
	
	double test3(int[] x) {// 문제3) 전교생의 평균 리턴 메서드
		int sum = 0;
		for(int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		double avg = (double) sum / x.length;
		return avg;
	}
	
	int test4(int[] x) {// 문제4) 성적이 60점 이상이면 합격. 합격생 수 리턴 메서드
		int cnt = 0;
		for(int i = 0; i< x.length; i++) {
			if(x[i] >= 60) {
				cnt++; 
			}
		}
		return cnt; 
	}
	
	int test5(int[] x, int idx) {// 문제5) 인덱스를 전달받아 성적 리턴 메서드
		return x[idx]; 
	}
	
	int test6(int[] x, int score) {// 문제6) 성적을 전달받아 인덱스 리턴 메서드
		int idx = -1;
		for(int i = 0; i < x.length; i++) {
			if(x[i] == score) {
				idx = i; 
			}
		}
		return idx; 
	}
	
	int test7(int[] x, int[] y, int hakbun) {// 문제7) 학번을 전달받아 성적 리턴 메서드
		int sc = -1;
		for(int i = 0; i < x.length; i++) {
			if(x[i] == hakbun) {
				sc = y[i];
			}
		}
		return sc; 
	}

	Student test8(int[] x, int[] y) { // 문제9) 1등학생의 학번과 성적을 클래스 타입(Student 클래스)으로 리턴 메서드
		int max = 0;
		for(int i = 0; i < x.length; i++) {
			if(y[i] >= y[max]) {
				 max = i;
			}
		}
		Student st = new Student();
		st.hakbun = x[max];
		st.score = y[max];
		return st; 
	}
}

public class Ex02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		StudentMng sm = new StudentMng();
		
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores  = new int[5];

		// 문제1) scores배열에 1~100점 사이의 정수를 5개 저장 메서드
		// 예   1) 87, 11, 92, 14, 47
		sm.test1(scores);
		
		// 문제2) 전교생의 총점 리턴 메서드
		// 예   2) 총점(251) 평균(50.2)
		int sum = sm.test2(scores);
		System.out.println("총점 : "+ sum +"점");
		
		// 문제3) 전교생의 평균 리턴 메서드
		// 예   3) 평균(50.2)
		double avg = sm.test3(scores);
		System.out.println("평균 : "+ avg+"점");
		
		// 문제4) 성적이 60점 이상이면 합격. 합격생 수 리턴 메서드
		// 예   4) 2명
		int pass = sm.test4(scores);
		System.out.println("합격생 수 : " + pass + "명");

		// 문제5) 인덱스를 전달받아 성적 리턴 메서드
		// 정답5) 인덱스 입력 : 1	성적 : 11점
		System.out.print("인덱스 입력 : ");
		int idx = in.nextInt();
		int score = sm.test5(scores, idx);
		System.out.println(idx + "번째 학생 성적 : " + score+ "점");
		
		// 문제6) 성적을 전달받아 인덱스 리턴 메서드
		//		  단, 없는 성적 입력 시 예외처리		
		// 정답6) 성적 입력 : 11	인덱스 : 1
		System.out.println("성적 입력 : ");
		int ss = in.nextInt();
		int idx2 = sm.test6(scores, ss);
		if(idx2 == -1) {
			System.out.println("해당 성적을 가진 학생 존재 하지 않음.");
		}else {
			System.out.println(ss+"점인 학생의 인덱스 : " +idx2);
		}
		
		// 문제7) 학번을 전달받아 성적 리턴 메서드
		// 		  단, 없는학번 입력 시 예외처리
		// 예   7)
		// 학번 입력 : 1002		성적 : 11점
		// 학번 입력 : 1000		해당 학번은 존재하지 않습니다.
		System.out.println("학번 입력 : ");
		int sh = in.nextInt();
		int sc = sm.test7(hakbuns, scores, sh);
		if(sc != -1) {
			System.out.println(sh + "번의 성적 : " + sc+"점");
		}else {
			System.out.println("해당 학번은 존재하지 않습니다.");
		}
		
		// 문제9) 1등학생의 학번과 성적을 클래스 타입(Student 클래스)으로 리턴 메서드
		// 정답9) 1004번(98점)
		Student st = sm.test8(hakbuns, scores);
		System.out.println("1등학생은 "+st.hakbun+"번("+st.score+"점) 입니다.");
	}
}
