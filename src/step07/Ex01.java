package step07;

//# 학생성적관리 프로그램(1단계)[문제]

class ScoreMng{
	
	int test1(int[] arr) { return 0; }
	int test2(int[] arr) { return 0; }
	int test3(int[] arr) { return 0; }
	int test4(int[] arr) { return 0; }

}

public class Ex01 {
	public static void main(String[] args) {
		
		ScoreMng sm = new ScoreMng();
		
		int[] arr = {87, 100, 11, 72, 92};

		// 문제 1) 전체 합 리턴
		// 정답 1) 362
		sm.test1(arr);
		
		// 문제 2) 4의 배수의 합 리턴
		// 정답 2) 264
		sm.test2(arr);
		
		// 문제 3) 4의 배수의 개수 리턴
		// 정답 3) 3
		sm.test3(arr);
		
		// 문제 4) 짝수의 개수 리턴
		// 정답 4) 3
		sm.test4(arr);
		
	}
}
