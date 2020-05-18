package step06;

//# 학생성적관리 프로그램(1단계)[문제]

class ScoreMng{
	int[] arr = {87, 100, 11, 72, 92};
	int add = 0;
	int dadd = 0;
	int dcnt = 0;
	int evcnt = 0;
}

public class Ex01 {
	public static void main(String[] args) {

		// 문제 1) 전체 합 출력
		// 정답 1) 362
		
		// 문제 2) 4의 배수의 합 출력
		// 정답 2) 264
		
		// 문제 3) 4의 배수의 개수 출력
		// 정답 3) 3
		
		// 문제 4) 짝수의 개수 출력
		// 정답 4) 3

		ScoreMng sm = new ScoreMng();
		
		for(int i = 0; i < sm.arr.length; i++) {
			sm.add += sm.arr[i];
			if(sm.arr[i] % 4 == 0) {
				sm.dadd += sm.arr[i];
				sm.dcnt++;
			}
			if(sm.arr[i] % 2 == 0) sm.evcnt++;
			System.out.print(sm.arr[i] + " ");
		}
		System.out.println("\n전체 합 : " + sm.add);
		System.out.println("4의 배수의 합 : " + sm.dadd);
		System.out.println("4의 배수의 개수 : " + sm.dcnt);
		System.out.println("짝수의 개수 : " + sm.evcnt);
	}
}
