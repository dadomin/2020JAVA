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
		int[] tmp = score;
		int[] c = correctA(score);
		int cnt = 0;
		
		while(true) {
			for(int i = 0; i < score.length; i++) {
				System.out.print(score[i] + " ");
			}
			System.out.println("");
			
			if(compare(score, c)) break;

			int max = searchMax(tmp);
			for(int i = 0; i < score.length; i++) {
				if(score[i] == max) {
					score[i] = score[0 + cnt];
					score[0 + cnt] = max;
					cnt++;
				}
			}
			tmp = new int[score.length - cnt];
			for(int i = 0; i < tmp.length; i++) {
				tmp[i] = score[i+cnt];
			}
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
		for(int i = 0; i < arr.length; i++) {
			c[i] = arr[i];
		}
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < i; j++) {
				if(c[j] < c[i]) {
					int t = c[i];
					c[i] = c[j];
					c[j] = t;
				}
			}
		}
		return c;
	}
	
	public static boolean compare(int[] a, int[] b) {
		boolean t = true;
		for(int i = 0; i < a.length; i++) {
			if(a[i] != b[i]) {
				t = false;
			}
		}
		return t;
	}
	
	
}
