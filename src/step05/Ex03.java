package step05;

import java.util.Scanner;

// # 관리비[문제]

public class Ex03 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[][] apt = {
			{101, 102, 103},	
			{201, 202, 203},	
			{301, 302, 303}	
		};
			
		int[][] pay = {
			{1000, 2100, 1300},	
			{4100, 2000, 1000},	
			{3000, 1600,  800}
		};
			
		// 문제 1) 각층별 관리비 합 출력
		// 정답 1) 4400, 7100, 5400
		
		// 문제 2) 호를 입력하면 관리비 출력
		// 예    2) 입력 : 202	관리비 출력 : 2000
		
		// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
		// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)
		
		// 문제 4) 호 2개를 입력하면 관리비 교체
		
		while(true) {
			for(int i = 0; i < apt.length; i++) {
				for(int j = 0; j < apt[i].length; j++) {
					System.out.print(apt[i][j] + "호 :" + pay[i][j] + "원\t");
				}
				System.out.println("");
			}
			System.out.println("[1] 각 층 별 관리비의 합");
			System.out.println("[2] 입력하신 호수의 관리비");
			System.out.println("[3] 관리비가 가장 많이 나온 집, 적게 나온 집 조회");
			System.out.println("[4] 관리비 교체하기");
			System.out.println("[0] 종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = in.nextInt();
			if(sel == 1) {
				System.out.println("[ 각 층 별 관리비의 합 출력하기 ]");
				for(int i = 0; i < pay.length; i++) {
					int add = 0;
					for(int j = 0; j < pay[i].length; j++) {
						add += pay[i][j];
					}
					System.out.println((i+1)+"층 관리비 : " + add +"원");
				}
			}else if(sel == 2) {
				System.out.println("[ 호를 입력하면 관리비 출력 ]");
				int w = in.nextInt();
				for(int i = 0; i < apt.length; i++) {
					for(int j = 0; j < apt[i].length; j++) {
						if(w == apt[i][j]) {
							System.out.println(w + "호 관리비 : " + pay[i][j] + "원");
						}
					}
				}
			}else if(sel == 3) {
				System.out.println("\n[ 가장 많이 나온 집, 적게 나온 집 출력 ]");
				int max = pay[0][0];
				int min = pay[0][0];
				for(int i = 0; i < pay.length; i++) {
					for(int j = 0; j < pay[i].length; j++) {
						if(pay[i][j] >= max) {
							max = pay[i][j];
						}
						if(pay[i][j] <= min) {
							min = pay[i][j];
						}
					}
				}
				
				for(int i = 0; i < pay.length; i++) {
					for(int j = 0; j < pay[i].length; j++) {
						if(pay[i][j] == max) {
							System.out.println("가장 많이 나온 집 : " + apt[i][j] +"호");
						}
						if(pay[i][j] == min) {
							System.out.println("가장 적게 나온 집 : " + apt[i][j] +"호");
						}
					}
				}
			}else if(sel == 4) {
				System.out.println("[ 관리비를 서로 교체할 호수 입력 ]");
				System.out.print("첫번째 호수 : ");
				int m = in.nextInt();
				System.out.print("두번째 호수 : ");
				int n = in.nextInt();
				int mp = -1;
				int mi = -1, mj=-1;
				int np = -1;
				for(int i = 0; i < apt.length; i++) {
					for(int j = 0; j < apt[i].length; j++) {
						if(m == apt[i][j]) {
							mp = pay[i][j];
							mi = i; mj = j;
						}
						if(n == apt[i][j]) {
							np = pay[i][j];
						}
					}
				}
				
				if(mp == -1 || np == -1) {
					System.out.println("호수 입력이 올바르지 않습니다.");
					continue;
				}
				
				for(int i = 0; i < pay.length; i++) {
					for(int j = 0; j < pay[i].length; j++) {
						if(pay[i][j] == np) {
							pay[i][j] = mp;
						}
					}
				}
				pay[mi][mj] = np;
				
			}else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
		in.close(); //스캐너 반환
	}
}
