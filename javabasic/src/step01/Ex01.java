package step01;

/*
 * # 怨쇰씫[臾몄젣]
 * 1. �븘�옒 �꽭 怨쇰ぉ�쓽 �꽦�쟻 �룊洹좎씠 60�젏 �씠�긽�씠硫� �빀寃⑹깮�씠�떎.
 * 2. �떒, �뼱�뒓 �븳 怨쇰ぉ�씠�씪�룄 �젏�닔媛� 50�젏 誘몃쭔�씠硫� 遺덊빀寃⑹깮�씠�떎.
 * 3. �빀寃� �뿬遺�瑜� 異쒕젰�븳�떎.
 */

public class Ex01 {
	public static void main(String[] args) {

		int kor = 87; // 援��뼱 �젏�닔
		int eng = 100; // �쁺�뼱 �젏�닔
		int math = 42; // �닔�븰 �젏�닔
		
		boolean pass = true; // �빀寃� �뿬遺�
		double avg = (double)(kor + eng + math) / 3; // �룊洹� �젏�닔
		
		//�룊洹좎씠 60�젏 誘몃쭔�씠硫� 遺덊빀寃�
		if(avg < 60) {
			pass = false;
		}
		
		// 怨쇰ぉ�떦 �젏�닔媛� 50�젏 誘몃쭔�씠 �븯�굹�씪�룄 �엳�쑝硫� 遺덊빀寃�
		if(kor < 50 || eng < 50 || math < 50) {
			pass = false;
		}
		
		//�빀寃� �뿬遺� 異쒕젰
		if(pass) {
			System.out.println("�빀寃�");
		}else {
			System.out.println("遺덊빀寃�");
		}
		
	}
}
