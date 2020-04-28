package step07;

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

class Theater{
	
	Scanner scan = new Scanner(System.in);

	int[] seat = new int[10];
	
	String name = "";				// 영화관 이름
	int cnt = 0;					// 예매 수
	int money = 0;					// 매출액
}

public class Ex04 {
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		Theater t = new Theater();
		System.out.print("영화관 이름 정하기 : ");
		String name = t.scan.next();
		t.name = name;
		
		while(true) {
			
			System.out.println(t.name);
			System.out.println("[1]좌석예매");
			System.out.println("[2]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = t.scan.nextInt();
			
			if(sel == 1) {
				System.out.print("seat = ");
				for(int i = 0; i < t.seat.length; i++) {
					System.out.print(t.seat[i] + " ");
				}
				System.out.println("");
				System.out.print("\n좌석선택 : ");
				int s = t.scan.nextInt();
				if(s >= 0 && s < 7) {
					if(t.seat[s] == 1) {
						System.out.println("이미 선택된 좌석입니다. 좌석 예매를 다시 시도해주세요.");
						continue;
					}
					t.seat[s] = 1;
					t.money += 12000;
					System.out.print("seat = ");
					for(int i = 0; i < t.seat.length; i++) {
						System.out.print(t.seat[i] + " ");
					}
					System.out.println("");
				}
			}
			else if(sel == 2) {
				break;
			}
		}
		
		System.out.println("\n----------------------");
		System.out.println("매출액 : " + t.money +"원");
		t.scan.close();
	}
}
