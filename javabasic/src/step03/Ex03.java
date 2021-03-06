package step03;

import java.util.Random;

/*
 * # 랜덤학생[문제]
 * 1. 10회 반복을 한다.
 * 2. 1~100 사이의 랜덤 숫자를 저장한다.
 * 3. 위 숫자가 60점 이상이면, 합격생이다.
 * ------------------------------
 * 4. 10명 학생의 총점과 평균을 출력한다.
 * 5. 합격생 수를 출력한다.
 * 6. 1등학생의 번호와 성적을 출력한다.
 * 
 * 예) 87 11 92 42 100 23 68 33 8 75
 * [1] 총점 = 539점
 * [2] 평균 = 53.9점
 * [3] 합격생 수 = 5명
 * [4] 1등 = 100점(5번)
 */

public class Ex03 {
	public static void main(String[] args) {

		Random rnd = new Random(); //랜덤 객체
		int[] st = new int[10]; // 학생 10명의 성적을 담는 배열
		
		// 10명의 학생의 랜덤한 성적 배열에 담기
		for(int i = 0; i < 10; i++) {
			int r = rnd.nextInt(100) + 1;
			st[i] = r;
			System.out.print(r + " ");
		}
		
		int total = 0; // 총점
		int pass = 0; // 합격한 학생 수
		int max = 0; // 1등 점수 ( 최고점 )
		
		for(int i = 0; i < st.length; i++) {
			
			// 총점 계산
			total += st[i];
			
			// 합격생 수 계산 (60점 이상)
			if(st[i] >= 60) {
				pass++;
			}
			
			// 최고점 구하기
			if(st[i] > max) {
				max = st[i];
			}
		}
		
		// 출력
		System.out.println("\n[1] 총점 = " + total +"점");
		System.out.println("[2] 평균 = " + (double)total / 10 + "점");
		System.out.println("[3] 합격생수 = " + pass + "명");
		System.out.println("[4] 1등 = " + max + "점");
		
	}
}
