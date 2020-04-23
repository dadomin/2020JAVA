package step08;

public class Student {
	String id;
	String pw;
	int score;
	
	void setData(String id, String pw, int score) {
		this.id = id;
		this.pw = pw;
		this.score = score;
	}
	
	void printData() {
		System.out.println("이름 : " + id + " 비밀번호 : " + pw + " 성적 : " + score);
	}
}
