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

		int money = 87900; // 바꿔야 할 금액
		
		int m = 50000; // 화폐단위
		int cnt = 0; // 화폐당 장수
		boolean five = true; // 앞자리가 5인지 아닌지 판별해줌
		for(int i = 0; i< 6; i++) {
			cnt = money / m; // 금액을 화폐로 나눈 몫 == 화폐당 장수
			// 화폐당 장수 출력
			System.out.println(m + "원 : " + cnt +"장");
			money %= m; // 화폐단위로 나눈 나머지를 금액변수에 담기
			
			//화폐단위 바꾸는 코드
			if(five) {
				// 앞자리가 5일 경우 5로 나눈다. ex) 5000 -> 1000 (5000원 다음 단위는 1000원)
				m /= 5;
			}else {
				// 앞자리가 5가 아닐 경우 2로 나눈다. ex) 10000 -> 5000 (10000원 다음 단위는 5000원)
				m /= 2;
			}
			//화폐단위를 바꿨으므로 5판별 변수를 바꾸어 준다 (화폐앞자리수는 5,1을 반복한다)
			five = !five;
		}
		
	}
}
