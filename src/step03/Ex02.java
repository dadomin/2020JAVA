package step03;

import java.util.Scanner;

/*
 * # 영수증 출력(2단계)[문제]
 * 1. 메뉴판의 번호를 입력받아 주문을 받는다.
 * 2. 계산하기를 누르면, 영수증을 출력한다.
 * 3. 돈을 입력받아, 잔돈을 출력한다.
 */

public class Ex02 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in); // 스캐너
		
		int price1 = 3400; // 1번 메뉴 -싸이버거- 금액
		int price2 = 4100; // 2번 메뉴 -포테이토버거- 금액
		int price3 = 1700; // 3번 메뉴 -감자튀김- 금액
		
		int cnt1 = 0; // 1번 메뉴 -싸이버거- 개수
		int cnt2 = 0; // 2번 메뉴 -포테이토버거- 개수
		int cnt3 = 0; // 3번 메뉴 -감자튀김- 개수
		
		while(true) {
			
			//메뉴와 가격 출력
			System.out.println("[Moms Burger Menu]");
			System.out.println("[1]싸이버거 : " + price1 + "원");
			System.out.println("[2]포테이토버거 : " + price2 + "원");
			System.out.println("[3]감자튀김 : " + price3 + "원");
			System.out.println("[0]계산하기");
			
			//메뉴 선택하기
			System.out.print("메뉴를 선택하세요 : ");
			int sel = in.nextInt();
			
			if(sel == 1) {
				//싸이버거 선택
				System.out.println("[메세지]싸이버거 1개 주문하였습니다.");
				cnt1++;
			}
			else if(sel == 2) {
				//포테이토버거 선택
				System.out.println("[메세지]포테이토버거 1개 주문하였습니다.");
				cnt2++;
			}
			else if(sel == 3) {
				//감자튀김 선택
				System.out.println("[메세지]감자튀김 1개 주문하였습니다.");
				cnt3++;
			}
			else if(sel == 0) {
				//종료
				break;
			}
			
		}
		
		//총 금액 계산
		int total = cnt1 * price1 + cnt2 * price2 + cnt3 * price3;
		
		//영수증 출력
		System.out.println("======= 영 수 증 =======");
		if(cnt1 != 0) {
			System.out.println("싸이버거 : " + cnt1 + " 개");
		}
		if(cnt2 != 0) {
			System.out.println("포테이토버거 : " + cnt2 + " 개");
		}
		if(cnt3 != 0) {
			System.out.println("감자튀김 : " + cnt3 + " 개");
		}
		System.out.println(" 총 금액 : " + total + " 원");
		System.out.println("=====================");
		
		in.close(); //스캐너 반환
	}
}
