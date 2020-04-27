package step03;

import java.util.Random;
import java.util.Scanner;

/*
 * # 구구단 게임(3단계)[문제]
 * 1. 랜덤 숫자를 2개 저장하여,
 * 2. 구구단 문제를 5회 출제한다.
 * 3. 한 문제당 20점으로 게임 종료 후 게임성적을 출력한다.
 */

public class Ex01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("구구단 게임");
		
		Random rnd = new Random(); //랜덤 객체 생성
		
		int score = 0; //총 성적을 담는 변수
		
		//랜덤한 숫자 2개 배열에 저장
		int[] r = new int[2];
		for(int i = 0; i < 2; i++) {
			r[i] = rnd.nextInt(9) + 1;
		}
		
		//r배열에서 0-1중 랜덤한 숫자 m번째의 값과 
		//0-9사이 랜덤값 n을 곱한 값이랑 일치여부를 따져서 점수 매기기
		for(int i = 0; i < 5; i ++) {
			int m = rnd.nextInt(2);
			int n = rnd.nextInt(9) + 1;
			System.out.print(r[m] + " X " + n + " = ");
			int answer = in.nextInt();
			if(answer == r[m] * n) {
				score += 20;
			}
		}
		
		//총 점 출력
		System.out.println("성적 : " + score + "점");
		
		in.close(); //스캐너 반환
	}
}
