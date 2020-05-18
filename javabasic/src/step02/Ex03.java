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

		Scanner in = new Scanner(System.in); //스캐너
		
		int acc1 = 1111; // 1번 ID
		int pw1 = 1234; // 1번 PW
		int money1 = 10000; // 1번 돈
		
		int acc2 = 2222; // 2번 ID
		int pw2 = 1234; // 2번 PW
		int money2 = 20000; // 2번 돈
		
		/*
		 * # log 값의 의미
		 * (1)로그아웃			: -1
		 * (2)acc1 로그인		: 1
		 * (3)acc2 로그인		: 2
		 */
		
		int log = -1; // 현재 로그아웃 중
		
		while(true) {
			
			// 메뉴 보여주기
			System.out.println("[MEGA ATM]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]입금");
			System.out.println("[4]출금");
			System.out.println("[5]이체");
			System.out.println("[6]잔액조회");
			System.out.println("[0]종료");
			
			// 메뉴 선택
			System.out.print("메뉴를 선택하세요 : ");
			int sel = in.nextInt();
			
			if(sel == 1) {
				
				//로그인
				
				// 다른 계정 로그인인 경우
				if(log > 0) {
					System.out.println("로그인 실패. 로그아웃 후 이용하세요.");
					continue;
				}
				
				// 아이디 입력
				System.out.print("아이디 입력 : ");
				int id = in.nextInt();
				
				// 비번 입력
				System.out.print("비밀번호 입력 : ");
				int pw = in.nextInt();
				
				if(id == acc1 && pw == pw1) {
					// 1번 회원 로그인 성공
					System.out.println("로그인 성공. id : acc1");
					log = 1;
				}else if(id == acc2 && pw == pw2) {
					// 2번 회원 로그인 성공
					System.out.println("로그인 성공. id : acc2");
					log = 2;
				}else {
					// 로그인 실패
					System.out.println("로그인 실패. 아이디와 비밀번호를 다시 확인해주세요.");
					continue;
				}
				
			} else if(sel == 2) { 
				
				//로그아웃
				
				if(log < 0) {
					// 이미 로그아웃 된 경우 반환
					System.out.println("로그아웃 실패. 로그아웃은 로그인 후에 이용가능합니다.");
					continue;
				}else {
					// 로그아웃 성공
					System.out.println("로그아웃 성공.");
					log = -1;
				}
				
			} else if(sel == 3) {
				
				 //입금
				
				//로그아웃된 상태일 경우
				if(log < 0) {
					System.out.println("입금 실패. 입금은 로그인 후에 이용가능합니다.");
					continue;
				}
				
				// 입금 금액 입력
				System.out.print("입금하실 금액 : ");
				int m = in.nextInt();
				
				// 계좌 별 입금 작업
				if(log == 1) { //1번 로그인 중일때
					money1 += m;
				}else if(log == 2) { //2번 로그인 중일때
					money2 += m;
				}
				
			} else if(sel == 4) {

				 // 출금
				
				//로그아웃된 상태일 경우
				if(log < 0) {
					System.out.println("출금 실패. 출금은 로그인 후에 이용가능합니다.");
					continue;
				}
				
				//출금 금액 입력
				System.out.print("출금하실 금액 : ");
				int m = in.nextInt();
				
				//출금 작업
				if(log == 1) { // 1번 계정 출금
					money1 -= m;
				}else if(log == 2) { // 2번 계정 출금
					money2 -= m;
				}
				
			} else if(sel == 5) { 
				
				//이체
				
				// 로그아웃 된 상태일 경우
				if(log < 0) {
					System.out.println("출금 실패. 출금은 로그인 후에 이용가능합니다.");
					continue;
				} 
				
				//이체 금액 입력
				System.out.print("이체하실 금액 입력 : ");
				int m = in.nextInt();
				
				//이체할 사람 입력
				System.out.println("이체할 사람 입력 : ");
				String mp = in.next();
				
				if(log == 1) {
					// 1번사람 로그인일 경우
					// 2번 사람의 id가 입력 된 경우만 이체
					if(mp.equals("acc2")) {
						System.out.println("acc2에게 "+m+"원 이체 성공.");
						money1 -= m;
						money2 += m;
					}else {
						System.out.println("이체 실패. 해당 사용자 조회 불가.");
					}
				}else if(log == 2) {
					// 2번사람 로그인일 경우
					// 1번 사람의 id가 입력 된 경우만 이체
					if(mp.equals("acc1")) {
						System.out.println("acc2에게 "+m+"원이체 성공.");
						money1 -= m;
						money2 += m;
					}else {
						System.out.println("이체 실패. 해당 사용자 조회 불가.");
					}
				}
				
			} else if(sel == 6) { 
				
				//잔액조회
				
				// 현재 로그아웃 상태일 경우
				if(log < 0) {
					System.out.println("출금 실패. 출금은 로그인 후에 이용가능합니다.");
					continue;
				} else if( log == 1) {
					//1번 로그인 상태일 경우 1번 금액 조회
					System.out.println("acc1님의 잔액 : " + money1 + "원");
				} else if( log == 2 ) {
					// 2번 로그인 상태일 경우 2번 금액 조회
					System.out.println("acc2님의 잔액 : " + money2 + "원");
				}
				
			} else if(sel == 0) { 
				
				//종료
				
				System.out.println("[메세지]프로그램 종료");
				break;
			}
			
		}
		
		in.close(); //스캐너 반환
		
	}
}
