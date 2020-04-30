package step07;

import java.util.Scanner;

//# ATM[문제]

class Bank{

	Scanner scan = new Scanner(System.in);
	
	String name = "";
	
	String[] arAcc = {"1111", "2222", "3333", "", ""};
	String[] arPw  = {"1234", "2345", "3456", "", ""};
	int[] arMoney  = {87000, 34000, 17500, 0, 0};
	
	int count = 3;
	
	int loginCheck = 2;			// 3333 로그인 중
}

public class Ex05 {
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		Bank b = new Bank();
		makeBankName(b);
		
		while(true) {

			int sel = choiceMenu(b); 
			
			if(sel == 1) {//회원가입
				register(b);
			} else if(sel == 2) { //회원탈퇴
				secession(b);
			} else if(sel == 3) { //로그인
				login(b);
			} else if(sel == 4) { //로그아웃
				logout(b);
			}else if(sel == 5) { //입금
				inputMoney(b);
			}else if(sel == 6) { //이체
				moveMoney(b);
			}else if(sel == 7) {//잔액 조회
				checkMoney(b);
			}
			else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
			
		}
		b.scan.close();
	}
	
	public static void makeBankName(Bank b) {
		System.out.print("은행 이름 정하기 : ");
		String name = b.scan.next();
		b.name = name;
	}
	
	public static int choiceMenu(Bank b) {

		System.out.println("[" + b.name + "]");
		System.out.println("[1]회원가입");
		System.out.println("[2]회원탈퇴");
		System.out.println("[3]로그인");
		System.out.println("[4]로그아웃");
		System.out.println("[5]입금하기");
		System.out.println("[6]이체하기");
		System.out.println("[7]잔액조회");
		System.out.println("[0]종료하기");
		
		System.out.print("메뉴 선택 : ");
		int sel = b.scan.nextInt();
		
		return sel;
	}
	
	public static void register(Bank b) { //회원가입
		if(b.loginCheck != -1) {
			System.out.println("로그아웃 후 이용가능");
		}else {

			System.out.print("아이디 입력 : ");
			String id = b.scan.next();
			System.out.print("비밀번호 입력 : ");
			String pw = b.scan.next();
			String[] tid = new String[b.count + 1];
			String[] tpw = new String[b.count+1];
			int[] tm = new int[b.count +1];
			for(int i = 0; i < b.count; i++) {
				tid[i] = b.arAcc[i];
				tpw[i] = b.arPw[i];
				tm[i] = b.arMoney[i];
			}
			tid[b.count] = id;
			tpw[b.count] = pw;
			tm[b.count] = 1000; 
			b.count++;
			b.arAcc = tid;
			b.arPw = tpw;
			b.arMoney = tm;
			System.out.println(id+ "님 회원가입 성공.");
		}
	}
	
	public static void secession(Bank b) { //탈퇴
		if(b.loginCheck == -1) {
			System.out.println("로그인 후 이용가능");
		}else {
			System.out.println(b.name + "님 탈퇴하시겠습니까?\n탈퇴 진행을 위한 비밀번호 입력");
			String pw = b.scan.next();
			if(b.arPw[b.loginCheck].equals(pw)) {
				String[] tid = new String[b.count - 1];
				String[] tpw = new String[b.count-1];
				int[] tm = new int[b.count -1];
				int tc = 0;
				b.count--;
				for(int i = 0; i < b.count; i++) {
					if(i == b.loginCheck) {
						tc++;
					}
					tid[i] = b.arAcc[i+tc];
					tpw[i] = b.arPw[i+tc];
					tm[i] = b.arMoney[i+tc];
				}
				b.arAcc = tid;
				b.arPw = tpw;
				b.arMoney = tm;
				System.out.println("회원탈퇴 완료");
				b.loginCheck = -1;
				b.name = "Mega Bank";
			}
		}
	}
	
	public static void login(Bank b) {
		if(b.loginCheck != -1) {
			System.out.println("로그아웃 후 이용 가능");
		}else {
			System.out.print("아이디 입력 : ");
			String id = b.scan.next();
			int tidx = -1;
			for(int i = 0; i < b.count; i++) {
				if(b.arAcc[i].equals(id)) {
					tidx = i;
				}
			}
			if(tidx == -1) {
				System.out.println("해당 아이디 존재하지 않음.");
			}else {
				System.out.print("비밀번호 입력 : ");
				String pw = b.scan.next();
				if(b.arPw[tidx].equals(pw)) {
					b.loginCheck = tidx;
					b.name = b.arAcc[b.loginCheck];
					System.out.println(b.name + "님 로그인 성공.");
				}else {
					System.out.println("로그인 실패.");
				}
			}
			
		}
		
	}
	
	public static void logout(Bank b ) {
		if(b.loginCheck == -1) {
			System.out.println("로그인 후 이용 가능.");
		}else {
			System.out.println("로그아웃 성공 .");
			b.loginCheck = -1;
			b.name = "Mega Bank";
		}
	}
	
	public static void inputMoney(Bank b) {
		if(b.loginCheck == -1) {
			System.out.println("로그인 후 이용 가능.");
		}else {
			System.out.print("입금하실 금액 입력 : ");
			int p = b.scan.nextInt();
			if(p <= 0) {
				System.out.println("입금 실패. 금액이 올바르지 않음.");
			}else {
				b.arMoney[b.loginCheck] += p;
				System.out.println(b.name+"님의 계좌로 "+p+"원 입금 성공.(현재 잔액 : "+b.arMoney[b.loginCheck] + "원)");
			}
			
		}
		
	}
	
	public static void moveMoney(Bank b) {
		if(b.loginCheck == -1) {
			System.out.println("로그인 후 이용 가능.");
		}else {
			System.out.print("이체할 아이디 입력 : ");
			String id = b.scan.next();
			int find = -1;
			for(int i = 0; i < b.count; i++) {
				if(b.arAcc[i].equals(id)) {
					find = i;
				}
			}
			if(find == -1) {
				System.out.println("이체 실패. 해당 아이디 존재하지 않음.");
			}else {
				System.out.println("이체시킬 금액 입력 : ");
				int m = b.scan.nextInt();
				if(m <= 0) {
					 System.out.println("이체 실패. 금액의 범위가 올바르지 않음.");
				}else if(m > b.arMoney[b.loginCheck]) {
					 System.out.println("이체 실패. 잔액 부족.");
				}else {
					b.arMoney[b.loginCheck] -= m;
					b.arMoney[find] += m;
					System.out.println(b.arAcc[find]+"님의 계좌로 "+m+"원 입금 성공.(현재 잔액 : "+b.arMoney[b.loginCheck] + "원)");
				}
			}
		
		}
		
	}
	
	public static void checkMoney(Bank b) {
		if(b.loginCheck == -1) {
			System.out.println("로그인 후 이용 가능.");
		}else {
			System.out.println("[ "+b.name+"님의 현재 잔액 ]");
			System.out.println(b.arMoney[b.loginCheck] + "원");
		}
	}
}
