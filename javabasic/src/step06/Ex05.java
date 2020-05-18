package step06;

import java.util.Scanner;

/*
 * # ATM(4단계)[문제]
 * 1. 회원가입
 * . id와 pw를 입력받아 가입
 * . 가입 시 돈 1000원 부여
 * . id 중복체크
 * 2. 회원탈퇴
 * . 로그인시에만 이용가능
 * 3. 로그인
 * . id와 pw를 입력받아 로그인
 * . 로그아웃 상태에서만 이용가능
 * 4. 로그아웃
 * . 로그인시에만 이용가능
 * 5. 입금
 * . 로그인시에만 이용가능
 * 6. 이체
 * . 로그인시에만 이용가능
 * 7. 잔액조회
 * . 로그인시에만 이용가능
 */

class ATM{
	String name = "";
	
	String[] arAcc = {"1111", "2222", "3333", "4444", "5555"};
	String[] arPw  = {"1234", "2345", "3456", "4567", "5678"};
	int[] arMoney  = {87000, 34000, 17500, 98000, 12500};
	
	int count = 5;
	
	// -1 : 로그아웃 , 나머지 인덱스 : 로그인 인덱스
	int loginCheck = -1;
}

public class Ex05 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ATM mega = new ATM();
		mega.name = "Mega Bank";
		
		while(true) {
			
			System.out.println("[" + mega.name + "]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금하기");
			System.out.println("[6]이체하기");
			System.out.println("[7]잔액조회");
			System.out.println("[0]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {//회원가입
				if(mega.loginCheck != -1) {
					System.out.println("로그아웃 후 이용가능");
					continue;
				}
				System.out.print("아이디 입력 : ");
				String id = scan.next();
				System.out.print("비밀번호 입력 : ");
				String pw = scan.next();
				String[] tid = new String[mega.count + 1];
				String[] tpw = new String[mega.count+1];
				int[] tm = new int[mega.count +1];
				for(int i = 0; i < mega.count; i++) {
					tid[i] = mega.arAcc[i];
					tpw[i] = mega.arPw[i];
					tm[i] = mega.arMoney[i];
				}
				tid[mega.count] = id;
				tpw[mega.count] = pw;
				tm[mega.count] = 1000; 
				mega.count++;
				mega.arAcc = tid;
				mega.arPw = tpw;
				mega.arMoney = tm;
				System.out.println(id+ "님 회원가입 성공.");
			}
			else if(sel == 2) { //회원탈퇴
				if(mega.loginCheck == -1) {
					System.out.println("로그인 후 이용가능");
					continue;
				}
				System.out.println(mega.name + "님 탈퇴하시겠습니까?\n탈퇴 진행을 위한 비밀번호 입력");
				String pw = scan.next();
				if(mega.arPw[mega.loginCheck].equals(pw)) {
					String[] tid = new String[mega.count - 1];
					String[] tpw = new String[mega.count-1];
					int[] tm = new int[mega.count -1];
					int tc = 0;
					mega.count--;
					for(int i = 0; i < mega.count; i++) {
						if(i == mega.loginCheck) {
							tc++;
						}
						tid[i] = mega.arAcc[i+tc];
						tpw[i] = mega.arPw[i+tc];
						tm[i] = mega.arMoney[i+tc];
					}
					mega.arAcc = tid;
					mega.arPw = tpw;
					mega.arMoney = tm;
					System.out.println("회원탈퇴 완료");
					mega.loginCheck = -1;
					mega.name = "Mega Bank";
				}
			}
			else if(sel == 3) { //로그인
				if(mega.loginCheck != -1) {
					System.out.println("로그아웃 후 이용 가능");
					continue;
				}
				System.out.print("아이디 입력 : ");
				String id = scan.next();
				int tidx = -1;
				for(int i = 0; i < mega.arAcc.length; i++) {
					if(mega.arAcc[i].equals(id)) {
						tidx = i;
					}
				}
				if(tidx == -1) {
					System.out.println("해당 아이디 존재하지 않음.");
					continue;
				}
				System.out.print("비밀번호 입력 : ");
				String pw = scan.next();
				if(mega.arPw[tidx].equals(pw)) {
					mega.loginCheck = tidx;
					mega.name = mega.arAcc[mega.loginCheck];
					System.out.println(mega.name + "님 로그인 성공.");
				}else {
					System.out.println("로그인 실패.");
					continue;
				}
			}
			else if(sel == 4) { //로그아웃
				if(mega.loginCheck == -1) {
					System.out.println("로그인 후 이용 가능.");
					continue;
				}
				System.out.println("로그아웃 성공 .");
				mega.loginCheck = -1;
				mega.name = "Mega Bank";
			}
			else if(sel == 5) { //입금
				if(mega.loginCheck == -1) {
					System.out.println("로그인 후 이용 가능.");
					continue;
				}
				System.out.print("입금하실 금액 입력 : ");
				int p = scan.nextInt();
				if(p <= 0) {
					System.out.println("입금 실패. 금액이 올바르지 않음.");
					continue;
				}
				mega.arMoney[mega.loginCheck] += p;
				System.out.println(mega.name+"님의 계좌로 "+p+"원 입금 성공.(현재 잔액 : "+mega.arMoney[mega.loginCheck] + "원)");
			}
			else if(sel == 6) { //이체
				if(mega.loginCheck == -1) {
					System.out.println("로그인 후 이용 가능.");
					continue;
				}
				System.out.print("이체할 아이디 입력 : ");
				String id = scan.next();
				int find = -1;
				for(int i = 0; i < mega.arAcc.length; i++) {
					if(mega.arAcc[i].equals(id)) {
						find = i;
					}
				}
				if(find == -1) {
					System.out.println("이체 실패. 해당 아이디 존재하지 않음.");
					continue;
				}
				System.out.println("이체시킬 금액 입력 : ");
				int m = scan.nextInt();
				if(m <= 0) {
					 System.out.println("이체 실패. 금액의 범위가 올바르지 않음.");
					 continue;
				}
				if(m > mega.arMoney[mega.loginCheck]) {
					 System.out.println("이체 실패. 잔액 부족.");
					 continue;
				}
				mega.arMoney[mega.loginCheck] -= m;
				mega.arMoney[find] += m;
				System.out.println(mega.arAcc[find]+"님의 계좌로 "+m+"원 입금 성공.(현재 잔액 : "+mega.arMoney[mega.loginCheck] + "원)");
			}
			else if(sel == 7) {//잔액 조회
				if(mega.loginCheck == -1) {
					System.out.println("로그인 후 이용 가능.");
					continue;
				}
				System.out.println("[ "+mega.name+"님의 현재 잔액 ]");
				System.out.println(mega.arMoney[mega.loginCheck] + "원");
			}
			else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}		
		
		scan.close();
		
	}
}




