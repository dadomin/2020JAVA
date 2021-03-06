package step02;

import java.util.Scanner;

/*
 * # 놀이기구 이용제한[문제]
 * 1. 키를 입력받는다.
 * 2. 키가 110 이상이면, 놀이기구 이용이 가능하다.
 * 3. 키가 110 미만이면, 놀이기구를 이용할 수 없다.
 * 4. 단, 부모님과 함께 온 경우에는 놀이기구를 이용할 수 있다.
 * 5. 부모님과의 동행여부를 1(yes) 또는 0(no)을 입력받아 확인한다.
 */

public class Ex02 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in); // 스캐너

		boolean use = true; // 놀이기구를 사용할수 있는지 없는지 판별해줌 
		// 일단 true해놓고 안되는 조건에 해당되는 경우 false로 전환해준다.
		
		//키 입력받기
		System.out.println("키를 입력하세요.");
		double tall = in.nextDouble();
		
		// 키가 110 미만일 경우 부모님 동행 여부 확인
		if(tall < 110) {
			System.out.println("부모님 동행 시 1을, 아닌경우 0을 입력해주세요.");
			int with = in.nextInt();
			if(with == 0) {
				use = false;
			}
		}	
		
		// 가능여부 출력
		if(use) {
			System.out.println("놀이기구 이용 가능");
		}else {
			System.out.println("놀이기구 이용 불가");
		}
		
		in.close(); //스캐너 반환
	}
}
