package step01;

/*
 * # 화폐매수[문제]
 * 해당 금액의 화폐 종류 별 화폐 매수를 출력한다.
 * 정답)
 * 5만원 : 1장
 * 1만원 : 3장
 * 5천원 : 1장
 * 1천원 : 2장
 * 5백원 : 1개
 * 1백원 : 4개
 */

public class Ex03 {
	public static void main(String[] args) {

		int money = 87900; 
		
		int m = 50000;
		int cnt = 0;
		boolean five = true;
		for(int i = 0; i< 6; i++) {
			cnt = money / m;
			System.out.println(m + "원 : " + cnt +"장");
			money %= m;
			if(five) {
				m /= 5;
			}else {
				m /= 2;
			}
			five = !five;
		}
		
	}
}
