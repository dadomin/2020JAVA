package step06;

import java.util.Random;
import java.util.Scanner;

//# 학생성적관리 프로그램(2단계)[문제]

class School{
	int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
	int[] scores  = new int[5];
	int total = 0;
	double avg = 0;
	int pass = 0;
}

public class Ex02 {
	public static void main(String[] args) {

		// 문제1) scores배열에 1~100점 사이의 정수를 5개 저장
		// 예   1) 87, 11, 92, 14, 47
		
		// 문제2) 전교생의 총점과 평균 출력
		// 예   2) 총점(251) 평균(50.2)

		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예   3) 2명
		
		// 문제4) 인덱스를 입력받아 성적 출력
		// 정답4) 인덱스 입력 : 1	성적 : 11점
		
		// 문제5) 성적을 입력받아 인덱스 출력
		// 정답5) 성적 입력 : 11		인덱스 : 1
		
		// 문제6) 학번을 입력받아 성적 출력
		// 정답6) 학번 입력 : 1003	성적 : 45점
		
		// 문제7) 학번을 입력받아 성적 출력
		// 		단, 없는학번 입력 시 예외처리
		// 예   7)
		// 학번 입력 : 1002		성적 : 11점
		// 학번 입력 : 1000		해당학번은 존재하지 않습니다.
		
		// 문제8) 1등학생의 학번과 성적 출력
		// 정답8) 1004번(98점)
		
		Random rnd = new Random();
		School s = new School();

		int max = s.scores[0];
		int ms = s.hakbuns[0];  
		for(int i = 0; i < s.hakbuns.length; i++) {
			s.scores[i] = rnd.nextInt(100) + 1;
			System.out.print(s.hakbuns[i]+"번 : " + s.scores[i] + "점\t");
			s.total += s.scores[i];
			if(s.scores[i] >= 60) s.pass++;
			if(s.scores[i] >= max) {max = s.scores[i]; ms = s.hakbuns[i];}
		}
		System.out.println("");
		
		s.avg = (double)s.total / s.scores.length;
		System.out.println("총점 : " +s.total+"점,  평균 :" + s.avg +"점");
		System.out.println("합격생 수 : " + s.pass +"명");
		System.out.println("1등 학생 : " + ms +"번(" + max + "점)");
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("인덱스 입력 : ");
		int idx = in.nextInt();
		System.out.println(idx + "번째 학생 성적 : " + s.scores[idx]);
		
		System.out.println("성적 입력 : ");
		int ss = in.nextInt();
		for(int i = 0; i < s.scores.length; i++) {
			if(s.scores[i] == ss) {
				System.out.println(ss+"점인 학생의 인덱스 : " +i);
			}
		}
		
		System.out.println("학번 입력 : ");
		int sh = in.nextInt();
		int sc = -1;
		for(int i = 0; i < s.hakbuns.length; i++) {
			if(s.hakbuns[i] == sh) {
				sc = s.scores[i];
			}
		}
		if(sc != -1) {
			System.out.println(sh + "번의 성적 : " + sc+"점");
		}else {
			System.out.println("해당 학번은 존재하지 않습니다.");
		}
		
		in.close();
	}
}
