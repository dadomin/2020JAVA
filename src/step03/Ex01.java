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
		
		Random rnd = new Random();
		
		int score = 0;
		
		int[] r = new int[2];
		for(int i = 0; i < 2; i++) {
			r[i] = rnd.nextInt()
		}
		
//		
//		for(int i = 0; i < 2; i++) {
//			int r = rnd.nextInt(9)+1;
//			for(int j = 0; j < 5; j++) {
//				int m = rnd.nextInt(9)+1;
//				System.out.print(r + " X " + m + " = " );
//				int answer = in.nextInt();
//				if(answer == r*m) {
//					score += 20;
//				}
//			}
//		}
		
		System.out.println("성적 : " + score + "점");
	}
}
