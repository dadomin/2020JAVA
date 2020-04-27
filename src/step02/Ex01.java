package step02;

import java.util.Scanner;

/*
 * # 로그인(3단계)[문제]
 * 1. ID를 입력받아 dbId와 일치여부를 확인한다.
 * 2. ID가 틀리면, "ID를 확인해주세요."라는 메세지를 출력한다.
 * 3. ID가 맞으면, PW를 입력할 수 있다.
 * 4. PW를 입력받아 dbPW와 일치여부를 확인한다.
 * 5. PW가 틀리면, "PW를 확인해주세요."라는 메세지를 출력한다.
 * 6. PW가 맞으면, "로그인 성공"이라는 메세지를 출력한다.
 */

public class Ex01 {
	public static void main(String[] args) {

		int dbId = 1111;
		int dbPw = 1234;
		
		Scanner in = new Scanner(System.in);
		//id 입력 & 확인
		while(true) {
			System.out.print("ID 입력 : ");
			int id = in.nextInt();
			if(id != dbId) {
				System.out.println("ID를 확인해주세요.");
			}else {
				break;
			}
		}
		
		//pw 입력 & 확인
		while(true) {
			System.out.print("PW 입력 : ");
			int pw = in.nextInt();
			if(pw != dbPw) {
				System.out.println("PW를 확인해주세요.");
			}else {
				break;
			}
		}
		
		System.out.println("로그인 성공");
		
		in.close(); //스캐너 반환
		
	}
}
