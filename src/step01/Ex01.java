package step01;

/*
 * # 과락[문제]
 * 1. 아래 세 과목의 성적 평균이 60점 이상이면 합격생이다.
 * 2. 단, 어느 한 과목이라도 점수가 50점 미만이면 불합격생이다.
 * 3. 합격 여부를 출력한다.
 */

public class Ex01 {
	public static void main(String[] args) {

		int kor = 87;
		int eng = 100;
		int math = 42;
		
		boolean pass = true;
		double avg = (double)(kor + eng + math) / 3;
		if(avg < 60) {
			pass = false;
		}
		if(kor < 50 || eng < 50 || math < 50) {
			pass = false;
		}
		
		if(pass) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}
}
