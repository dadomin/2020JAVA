package step08;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StudentMng manager = new StudentMng();
		
		boolean run  = true;
		while(run) {
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				Student temp = new Student();
				System.out.println("[가입] id 를 입력하세요 >>> ");
				temp.id = scan.next();			
				int check =  manager.checkId(temp);
				if(check == -1) {
					System.out.println("[가입] pw 를 입력하세요 >>> ");
					temp.pw = scan.next();
					
					System.out.println("[가입] score 를 입력하세요 >>> ");
					temp.score = scan.nextInt();
					
					manager.addStudent(temp);	
					
					System.out.println(temp.id + "님 가입을 환영합니다.");
				}else {
					System.out.println("중복아이디 입니다.");
				}				
			}else if(sel == 2) {
				manager.printStudent();
				
				Student temp = new Student();
				System.out.println("[탈퇴] id 를 입력하세요 >>> ");
				temp.id = scan.next();	
				int check = manager.checkId(temp);
				if(check == -1) {
					System.out.println("없는 아이디입니다.");
				}else {
					Student del_st = manager.removeStudent(check);
					System.out.println(del_st.id + "님 탈퇴 되었습니다.");
				}
			}else if(sel == 3) {
				manager.sortData();
				manager.printStudent();
			}else if(sel == 4) {
				manager.printStudent();
			}
		}
		
		scan.close();
		
	}
}
