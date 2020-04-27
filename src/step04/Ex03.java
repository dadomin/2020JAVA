package step04;

import java.util.Scanner;

/*
 * # 배열 컨트롤러(1단계)[문제]
 * 1) 추가
 * 2) 삭제
 * 3) 삽입
 */

public class Ex03 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {10, 20, 0, 0, 0};
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		
//		int cnt = 2;
		
		boolean run = true;
		while(run) {
			
			System.out.println("[1]추가");
			System.out.println("[2]삭제");
			System.out.println("[3]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				System.out.print("추가할 값 입력 : ");
				int data = scan.nextInt();
				int[] temp = new int[arr.length+1];
				for(int i = 0; i < arr.length; i++) {
					temp[i] = arr[i];
				}
				temp[temp.length-1] = data;
				arr = temp;
				for(int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println("");
				
			}
			else if(sel == 2) {
				
				System.out.print("삭제할 값 입력 : ");
				int data = scan.nextInt();
				
				int find = 0;
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] == data) {
						find++;
					}
				}
				
				if(find != 0) {
					int[] tmp = new int[arr.length - find];
					int tc = 0;
					for(int i = 0; i < tmp.length; i++) {
						if(arr[i] == data) {
							tc++;
						}
						tmp[i] = arr[i+tc];
					}
					arr = tmp;
				}else {
					System.out.println("해당 값을 가진 인덱스 존재하지 않음");
				}
				
				for(int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println("");
				
			}
			else if(sel == 3) {
				
				System.out.print("삽입할 위치 입력 : ");
				int idx = scan.nextInt();
				
				System.out.print("삽입할 값 입력 : ");
				int data = scan.nextInt();
				
				int[] tmp = new int[arr.length+1];
				int tc = 0;
				for(int i = 0; i < arr.length; i++) {
					if(i == idx) {
						tmp[i] = data;
						tc++;
					}else {
						tmp[i] = arr[i-tc];	
					}
					
				}
				arr = tmp;
				
				for(int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println("");
				
			}
			else if(sel == 0) {
				run = false;
				System.out.println("프로그램 종료");
			}
			
		}
		
		scan.close();
		
	}
}
