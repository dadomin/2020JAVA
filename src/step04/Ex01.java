package step04;

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

public class Ex01 {
	public static void main(String[] args) {

		int[] answer = {1, 3, 4, 2, 5};
		int[] student = new int[5];
		String[] omr = new String[5]; 
		Random rd = new Random();
		int score = 0;
		
		System.out.print("answer = {");
		for(int i = 0; i < answer.length; i++) {
			if(i == answer.length-1) {
				System.out.print(answer[i] + "}");
				continue;
			}
			System.out.print(answer[i] + ", ");
		}
	
		System.out.print("\nstudnet = {");
		for(int i = 0; i < student.length; i++) {
			int rdNum = rd.nextInt(5)+1; 
			student[i] = rdNum;
			if(i == student.length-1) {
				System.out.print(student[i] + "}");
				continue;
			}
			System.out.print(student[i] + ", ");
		}
		
		System.out.print("\n정오표 = {");
		for(int i = 0; i < student.length; i++) {
	
			if(answer[i] == student[i]) {
				omr[i] = "O";
				score += 20;
			}else {
				omr[i] ="X"; 
			}
			if(i == omr.length-1) {
				System.out.print(omr[i] + "}");
				continue;
			}
			System.out.print(omr[i] + ", ");
		}
		
		System.out.println("\n성적 = " + score + "점");
		
	}
}
