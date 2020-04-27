package step05;

/*
 * # 정렬하기[문제]
 * 1. 인덱스 0번이 나머지를 검사한다.
 * 2. 제일 큰 값을 찾아 교환한다.
 * 3. 인덱스 1증가한다.
 * 4. [1~3]을 끝까지 반복한다.
 * 예)
 * 10, 50, 30, 40, 80, 7
 * 80, 50, 30, 40, 10, 7
 * 80, 50, 30, 40, 10, 7
 * 80, 50, 40, 30, 10, 7
 */

public class Ex02 {
	public static void main(String[] args) {
		
		int[] score = {10, 50, 30, 40, 80, 7};
		int max = searchMax(score);
		
		while(true) {
			for(int i = 0; i < score.length; i++) {
				System.out.print(score[i] + " ");
			}
			System.out.println("");
			if(score[0] == max) break;
			
		}
		
	}
	
	public static int searchMax(int[] arr) {
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static int[] correctA(int[] arr) {
		int[] c = new int[arr.length];
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i; j < arr.length; j++) {
				
			}
		}
		return c;
	}
}
