package step04;

import java.util.Scanner;

/*
 * # ATM(3단계)[문제]
 * 1. 가입
 * . 계좌번호와 비밀번호를 입력받아 가입
 * . 계좌번호 중복검사
 * 2. 탈퇴
 * . 계좌번호를 입력받아 탈퇴
 */

public class Ex04 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] accs = {1001, 1002, 0, 0, 0};
		int[] pws  = {1111, 2222, 0, 0, 0};
		
//		int cnt = 2;
		
		boolean run = true;
		while(run) {
			
			System.out.println("1.가입");
			System.out.println("2.탈퇴");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) { // 가입
				System.out.print("아이디 입력 : ");
				int id = scan.nextInt();
				System.out.print("비밀번호 입력 : ");
				int pw = scan.nextInt();
				int[] tac = new int[accs.length+1];
				int[] tpw = new int[pws.length+1];
				for(int i = 0; i < accs.length; i++) {
					tac[i] = accs[i];
					tpw[i] = pws[i];
				}
				tac[tac.length-1] = id;
				tpw[tpw.length-1] = pw;
				accs = tac;
				pws = tpw;
				System.out.println(id + "님  회원가입 되셨습니다.");
				
				for(int i = 0 ; i < accs.length; i++) {
					System.out.print(accs[i] + " ");
				}
				System.out.println("");
			}
			else if(sel == 2) {//탈퇴 
				System.out.print("아이디 입력 : ");
				int id = scan.nextInt();
				int idx = -1;
				for(int i = 0; i < accs.length; i++) {
					if(id == accs[i]) {
						idx = i;
						continue;
					}
				}
				if(idx == -1) {
					System.out.println("해당 아이디를 가진 회원이 존재하지 않음.");
					continue;
				}
				System.out.print("비밀번호 입력 : ");
				int pw = scan.nextInt();
				if(pw != pws[idx]) {
					System.out.println("비밀번호 불일치.");
					continue;
				}
				int[] tac = new int[accs.length-1];
				int[] tpw = new int[pws.length-1];
				int tc = 0;
				for(int i = 0; i < accs.length; i++) {
					if(accs[i] == id) {
						tc++;
					}else {
						tac[i-tc] = accs[i];
						tpw[i-tc] = pws[i];
					}
					
				}
				accs = tac;
				pws = tpw;
				System.out.println(id+"님이 성공적으로 탈퇴됨");
				
				for(int i = 0 ; i < accs.length; i++) {
					System.out.print(accs[i] + " ");
				}
				System.out.println("");
			}
			
		}
		
		scan.close();
		
	}
}
