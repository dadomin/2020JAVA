package step05;

import java.util.Scanner;

/*
 * # 최대값 구하기(3단계)[문제]
 * 1. 가장 큰 값을 찾아 입력한다.
 * 2. 정답이면 해당 값을 0으로 변경한다.
 * 3. arr배열의 모든 값이 0으로 변경되면 프로그램은 종료된다.
 * 예)
 * 11, 87, 42, 100, 24
 * 입력 : 100
 * 
 * 11, 87, 42, 0, 24
 * 입력 : 87
 * 
 * 11, 0, 42, 0, 24
 */

public class Ex01 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int[] arr = {11, 87, 42, 100, 24};
		while(true) {

			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("");
			
			int cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == 0) {
					cnt++;
				}
			}
			if(cnt == arr.length) break;
			
			int max = searchMax(arr);
			int idx = searchIdx(arr,max);
			
			System.out.print("가장 큰값 입력 : ");
			int m = in.nextInt();
			if(max == m) {
				arr[idx] = 0;
			}
			
		}
		
		in.close(); //스캐너 반환
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
	
	public static int searchIdx(int[] arr, int max) {
		int idx = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == max) {
				idx = i;
			}
		}
		return idx; 
	}
}
