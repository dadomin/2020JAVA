package step02;

import java.util.Scanner;

/*
 * # ATM[문제]
 * [1]로그인
 * . 계좌번호와 비밀번호를 입력받아 로그인을 처리한다.
 * . 이미 로그인 된 상태에서 다시 이용할 수 없다.
 * [2]로그아웃
 * . 로그아웃 상태에서 이용할 수 없다.
 * [3]입금
 * . 로그인 상태에서 이용할 수 있다.
 * . 입금할 금액을 입력받아 입금을 진행한다.
 * [4]출금
 * . 로그인 상태에서 이용할 수 있다.
 * . 출금할 금액이 계좌잔액을 초과할 경우 출금을 진행할 수 없다.
 * [5]이체
 * . 로그인 상태에서 이용할 수 있다.
 * . 이체할 계좌번호를 입력받아 처리한다.
 * . 이체할 금액이 계좌잔액을 초과할 경우 이체를 진행할 수 없다.
 * [6]잔액조회
 * . 로그인 상태에서 이용할 수 있다.
 * . 로그인 된 회원의 계좌잔액을 출력한다.
 */

public class Ex03 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int acc1 = 1111;
		int pw1 = 1234;
		int money1 = 10000;
		
		int acc2 = 2222;
		int pw2 = 1234;
		int money2 = 20000;
		
		/*
		 * # log 값의 의미
		 * (1)로그아웃			: -1
		 * (2)acc1 로그인		: 1
		 * (3)acc2 로그인		: 2
		 */
		int log = -1;
		
		while(true) {
			System.out.println("[MEGA ATM]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]입금");
			System.out.println("[4]출금");
			System.out.println("[5]이체");
			System.out.println("[6]잔액조회");
			System.out.println("[0]종료");
			
			System.out.print("메뉴를 선택하세요 : ");
			int sel = in.nextInt();
			
			if(sel == 1) { //로그인
				
				if(log > 0) {
					System.out.println("로그인 실패. 로그아웃 후 이용하세요.");
					continue;
				}
				
				System.out.print("아이디 입력 : ");
				int id = in.nextInt();
				
				System.out.print("비밀번호 입력 : ");
				int pw = in.nextInt();
				
				if(id == acc1 && pw == pw1) {
					System.out.println("로그인 성공. id : acc1");
					log = 1;
				}else if(id == acc2 && pw == pw2) {
					System.out.println("로그인 성공. id : acc2");
					log = 2;
				}else {
					System.out.println("로그인 실패. 아이디와 비밀번호를 다시 확인해주세요.");
					continue;
				}
				
			} else if(sel == 2) { //로그아웃
				
				if(log < 0) {
					System.out.println("로그아웃 실패. 로그아웃은 로그인 후에 이용가능합니다.");
					continue;
				}else {
					System.out.println("로그아웃 성공.");
					log = -1;
				}
				
			} else if(sel == 3) { //입금
				
				if(log < 0) {
					System.out.println("입금 실패. 입금은 로그인 후에 이용가능합니다.");
					continue;
				} 
				System.out.print("입금하실 금액 : ");
				int m = in.nextInt();
				if(log == 1) {
					money1 += m;
				}else if(log == 2) {
					money2 += m;
				}
				
			} else if(sel == 4) { // 출금

				if(log < 0) {
					System.out.println("출금 실패. 출금은 로그인 후에 이용가능합니다.");
					continue;
				} 
				System.out.print("출금하실 금액 : ");
				int m = in.nextInt();
				if(log == 1) {
					money1 -= m;
				}else if(log == 2) {
					money2 -= m;
				}
				
			} else if(sel == 5) { //이체
				
				if(log < 0) {
					System.out.println("출금 실패. 출금은 로그인 후에 이용가능합니다.");
					continue;
				} 
				System.out.print("이체하실 금액 입력 : ");
				int m = in.nextInt();
				System.out.println("이체할 사람 입력 : ");
				String mp = in.next();
				
				if(log == 1) {
					if(mp.equals("acc2")) {
						System.out.println("acc2에게 "+m+"원 이체 성공.");
						money1 -= m;
						money2 += m;
					}else {
						System.out.println("이체 실패. 해당 사용자 조회 불가.");
					}
				}else if(log == 2) {
					if(mp.equals("acc1")) {
						System.out.println("acc2에게 "+m+"원이체 성공.");
						money1 -= m;
						money2 += m;
					}else {
						System.out.println("이체 실패. 해당 사용자 조회 불가.");
					}
				}
				
			} else if(sel == 6) { //잔액조회
				
				if(log < 0) {
					System.out.println("출금 실패. 출금은 로그인 후에 이용가능합니다.");
					continue;
				} else if( log == 1) {
					System.out.println("acc1님의 잔액 : " + money1 + "원");
				} else if( log == 2 ) {
					System.out.println("acc2님의 잔액 : " + money2 + "원");
				}
				
			} else if(sel == 0) { //종료
				System.out.println("[메세지]프로그램 종료");
				break;
			}
			
		}
		
		in.close();
		
	}
}
