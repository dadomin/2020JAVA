package step01;

/*
 * # 값 교체[문제]
 * 1. x와 y의 값을 교체한다.
 * 2. 교체 후, 결과를 출력하면 다음과 같다.
 * 정답)
 * x = 20
 * y = 10
 */

public class Ex02 {
	public static void main(String[] args) {

		int x = 10; // x의 값
		int y = 20; // y의 값
		
		int tmp = x; // 임시 변수
		// 교체
		x = y;
		y = tmp;
		
		//바뀐 값 출력
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
	}
}
