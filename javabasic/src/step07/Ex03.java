package step07;

import java.util.Random;

/*
 * # OMR카드[문제]
 * 1. 배열 answer는 시험문제의 정답지이다.
 * 2. 배열 student에 1~5 사이의 랜덤 숫자 5개를 저장한다.
 * 3. answer와 student 값을 비교해 정오표를 출력한다.
 * 4. 한 문제당 20점이다.
 * 예)
 * answer  = {1, 3, 4, 2, 5}
 * student = {1, 1, 4, 4, 3}
 * 정오표      = {O, X, O, X, X}
 * 성적         = 40점
 */

class School{
	
	Random ran = new Random();
	
	int[] omr = {1, 4, 3, 2, 2};		// 모범답안
	int[] me = new int[5];				// 학생답안
	
	int cnt = 0;						// 정답 맞춘 개수
	int score = 0;						// 성적
	
	
}

public class Ex03 {
	public static void main(String[] args) {
		School sc = new School();
		run(sc);
	}
	
	public static void run(School oc) {
		
		showAnswer(oc);
		makeAnswer(oc);
		checkAnswer(oc);
	}
	
	public static void showAnswer(School oc) {

		System.out.print("answer = ");
		for(int i = 0; i < oc.omr.length; i++) {
			System.out.print(oc.omr[i] + " ");
		}
	}
	
	public static void makeAnswer(School oc) {
		
		System.out.print("\nstudent = ");
		for(int i = 0; i < oc.me.length; i++) {
			oc.me[i] = oc.ran.nextInt(5) + 1;
			System.out.print(oc.me[i] + " ");
		}
		
	}
	
	public static void checkAnswer(School oc) {

		System.out.print("\n정오표 = ");
		for(int i = 0; i < oc.omr.length; i++) {
			if(oc.omr[i] == oc.me[i]) {
				oc.cnt++;
				oc.score += 20;
				System.out.print("O ");
			}else {
				System.out.print("X ");
			}
		}
		
		System.out.print("\n성적 = " + oc.score + "점");
	}
	
	
}
