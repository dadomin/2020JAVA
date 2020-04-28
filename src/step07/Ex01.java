package step07;

//# 학생성적관리 프로그램(1단계)[문제]

class ScoreMng{
	
	int test1(int[] arr) { //전체 합
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	int test2(int[] arr) { //4의 배수의 합
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 4 == 0) {
				sum += arr[i];
			}
		}
		return sum;
	}
	
	int test3(int[] arr) { //4의 배수의 갯수
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 4 == 0) {
				cnt++;
			}
		}
		return cnt;
	}
	
	int test4(int[] arr) { //짝수의 개수
		int cnt = 0;
		for(int i = 0; i < arr.length;i++){
			if(arr[i] % 2 ==0) {
				cnt++;
			}
		}
		return cnt; 
	}

}

public class Ex01 {
	public static void main(String[] args) {
		
		ScoreMng sm = new ScoreMng();
		
		int[] arr = {87, 100, 11, 72, 92};

		// 문제 1) 전체 합 리턴
		// 정답 1) 362
		int add = sm.test1(arr);
		
		// 문제 2) 4의 배수의 합 리턴
		// 정답 2) 264
		int dadd = sm.test2(arr);
		
		// 문제 3) 4의 배수의 개수 리턴
		// 정답 3) 3
		int dcnt = sm.test3(arr);
		
		// 문제 4) 짝수의 개수 리턴
		// 정답 4) 3
		int even = sm.test4(arr);
		
		run(add, dadd,dcnt,even);
		
	}
	
	public static void run(int add,int dadd,int dcnt,int even) {

		System.out.println("전체 합 : " + add);
		System.out.println("4의 배수의 합 : "+ dadd);
		System.out.println("4의 배수의 개수 : "+ dcnt);
		System.out.println("짝수의 개수 : "+ even);
	}
}
