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

	}
}
