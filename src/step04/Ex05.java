package step04;

import java.util.Random;

/*
 * # 셔플[문제]
 * 1. 100번을 반복한다.
 * 2. 0~9사이의 랜덤한 숫자를 저장한다.
 * 3. arr의 0번째 값과 arr의 위 랜덤 숫자 위치의 값을 교체한다.
 * 4. 이를 통해 arr 배열의 값을 섞을 수 있다.
 */

public class Ex05 {
	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//섞기 전 
		System.out.println("[ 섞기 전 ]");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		//섞는 과정
		Random rnd = new Random();
		for(int i = 0; i < 100; i++) {
			int r = rnd.nextInt(10);
			int tmp = arr[0];
			arr[0] = arr[r];
			arr[r] = tmp;
		}
		
		//섞은 후 
		System.out.println("\n[ 섞은 후 ]");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
}
