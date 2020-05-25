package homework0521;

import java.util.Scanner;

/*
 * # ATM(3단계) -  10개 주석 문제 및 코드 작성하기
 * 1. 가입  == 배열컨트롤러 추가
 * . 계좌번호와 비밀번호를 입력받아 가입
 * . 계좌번호 중복검사
 * 2. 탈퇴 == 배열컨트롤러 삭제
 * . 계좌번호를 입력받아 탈퇴
 */

public class Ex04 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] accs = {1001, 1002, 0, 0, 0};
		int[] pws  = {1111, 2222, 0, 0, 0};
		
		int cnt = 2; //1. cnt 변수는 왜 2일까요?
				// 1번 답 : cnt는 가입된 계정의 개수를 나타내기 때문에
				// accs 배열에서 값을 가진 요소의 개수는 1001과 1002 2개이다. 고로 2를 할당한다.
		boolean run = true;
		while(run) {
			
			for(int i = 0; i < cnt; i++) {
				System.out.println((i+1) + "번째 계좌번호: " + accs[i] + " 비밀번호 : " + pws[i]);
			}
			System.out.println();
			System.out.println("1.가입");
			System.out.println("2.탈퇴");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {  // 1.가입  을 선택한 경우
				if(cnt == 5) { // 2. 왜 cnt가 5일때 가입 할 수 없을까요?
					// 2번 답 : accs 배열의 길이가 5이므로 추가하려면 값을 가진 요소가 0~4개일경우만 추가가 가능하다.
					// 5부터는 추가시에 길이를 넘어가므로 추가할 수 없다. 
					System.out.println("더이상 가입할 수 없습니다.");
					continue;
				}
				System.out.print("[가입]계좌번호 입력 : ");
				int myAcc = scan.nextInt();
				
				int check = 1; //3. check 변수의 역할은?
							// 3번 답 : 초기값인 1인 경우 - 가입이 정상적으로 가능하다.
							//		 : -1 인 경우 - 중복되는 계좌번호가 존재하기 때문에 가입이 불가능하다.
				for(int i = 0; i < cnt; i++) {
					if(accs[i] == myAcc) {// 4. 조건문을 글로 적으면?
										// 4번 답 : 가입을 원하는 계좌번호와 중복되는 계좌번호가 이미 존재할 경우
						check = -1;
					}
				}
				if(check == -1) {
					System.out.println("계좌번호가 중복됩니다.");
				}else {
					System.out.print("[가입]비밀번호 입력 : ");
					int myPw = scan.nextInt();
			//5. 계좌 가입으로 인해  계좌번호와 비밀번호의 배열 추가하는 코드 입력(3줄임)	
					accs[cnt] = myAcc;
					pws[cnt] = myPw;
					cnt++;
						
				}
			}
			else if(sel == 2) {//2.탈퇴를 선택한 경우
				
				System.out.print("[탈퇴]계좌번호 입력 : ");
				int myAcc = scan.nextInt();
				
				int check = -1; //6. check 변수의 역할은?
								// 6번 답 : 초기값인 -1인경우 -> 탈퇴중오류 발생(탈퇴하고자하는 계좌번호 존재하지 않음)
								//		: 나머지 -> 탈퇴하고자하는 계좌의 인덱스 값
				for(int i = 0; i < cnt; i++) {
					if(accs[i] == myAcc) {
						check = i; //7. check 변수에 i 값을 저장한다는 의미는?
									// 7번 답 : 탈퇴하고자 하는 계좌의 인덱스값을 저장한다.
					}
				}
				if(check == -1) {
					System.out.println("해당계좌번호는 존재하지 않습니다.");
				}else {
					for(int i = check; i < cnt-1; i++) {// 탈퇴 계좌번호의 인덱스 값을 갖고 있는 check ~ 총 계좌개수인 cnt보다 1작은 값까지 수행함.
			//8. 계좌 탈퇴로 인해 계좌번호와 비밀번호의 배열값을 앞 쪽으로 이동하는 코드 입력(2줄임)
						accs[i] = accs[i+1];
						pws[i] = pws[i+1];
					}
			//9. 계좌 삭제로 인한 배열값 이동에 따른 배열값 0으로 초기화 시키기(계좌번호와 비밀번호)
					accs[cnt] = 0;
					pws[cnt] = 0; 
			//10. 계촤 삭제로 인한 총 계좌 갯수 감소
					cnt--;
				}
			}		
		}	
		scan.close();
	}
}
