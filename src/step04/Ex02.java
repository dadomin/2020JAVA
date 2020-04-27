 package step04;

import java.util.Scanner;

/*
 * # 영화관 좌석예매[문제]
 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
 * 4. 한 좌석당 예매 가격은 12000원이다.
 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
 * 예)
 * seat = 0 0 0 0 0 0 0
 * 
 * 좌석선택 : 1
 * seat = 0 1 0 0 0 0 0
 * 
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * 
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * 이미 예매가 완료된 자리입니다.
 * ----------------------
 * 매출액 : 24000원
 */

public class Ex02 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] seat = new int[7];
		int price = 0;
		
		boolean run = true;
		while(run) {
			System.out.println("\n=메가 영화관=");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				System.out.print("seat = ");
				for(int i = 0; i < seat.length; i++) {
					System.out.print(seat[i] + " ");
				}
				System.out.println("");
				System.out.print("\n좌석선택 : ");
				int s = scan.nextInt();
				if(s >= 0 && s < 7) {
					if(seat[s] == 1) {
						System.out.println("이미 선택된 좌석입니다. 좌석 예매를 다시 시도해주세요.");
						continue;
					}
					seat[s] = 1;
					price += 12000;
					System.out.print("seat = ");
					for(int i = 0; i < seat.length; i++) {
						System.out.print(seat[i] + " ");
					}
					System.out.println("");
				}
			} else if(sel == 2) {
				run = false;
			}
			
		}
		System.out.println("\n----------------------");
		System.out.println("매출액 : " + price +"원");
		scan.close();
	}
}
