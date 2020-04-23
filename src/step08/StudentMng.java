package step08;

import java.util.ArrayList;

public class StudentMng {
	
	ArrayList<Student> list = new ArrayList<Student>();
	
	public StudentMng() {
		Student temp = new Student();
		temp.setData("qwer", "1111", 100);
		list.add(temp);
		
		temp = new Student();
		temp.setData("abcd", "2222", 87);
		list.add(temp);
		
		temp = new Student();
		temp.setData("javaking", "3333", 42);
		list.add(temp);
	}
	
	void addStudent(Student st) {
		list.add(st);
	}
	
	Student removeStudent(int index) {
		Student delSt = list.get(index);
		list.remove(index);
		return delSt;
	}
	
	int checkId(Student st) {
		int check = -1;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).id.equals(st.id)) {
				check = i;
				break;
			}
		}
		return check;
	}
	
	void printStudent() {
		for(int i=0; i<list.size(); i++) {
			list.get(i).printData();
		}
	}
	
	void sortData() {
		for(int i=0; i<list.size(); i++) {
			int maxScore = list.get(i).score;
			int maxIdx = i;
			for(int j=i; j<list.size(); j++) {
				if(maxScore < list.get(j).score) {
					maxScore = list.get(j).score;
					maxIdx = j;
				}
			}
			
			Student temp = list.get(i);
			list.set(i, list.get(maxIdx));
			list.set(maxIdx, temp);
		}
	}
	
	int getSize() {
		return list.size();
	}
}













