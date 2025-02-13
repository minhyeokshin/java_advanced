package Day9.workshop.studentWorkshop;

import java.io.Serializable;

/**
 * The type Student.
 */
public class Student implements Serializable {

	private static final long serialVersionUID = -1553498408278534089L;

	// 멤버 필드
	private String name;
	private int [] record;

	/**
	 * Instantiates a new Student.
	 *
	 * @param name   the name
	 * @param record the record
	 */
// 생성자
	public Student (String name, int[] record) {
		this.name = name;
		this.record = record;
	}
	public Student (String name, int kor, int eng, int math, int sci) {
		this.record = new int[4];
		this.name = name;
		this.record[0] = kor;
		this.record[1] = eng;
		this.record[2] = math;
		this.record[3] = sci;
	}

	// Getter & Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getRecord() {
		return record;
	}
	public void setRecord(int[] record) {
		this.record = record;
	}
	
	// 총점을 계산하여 반환하는 메소드
	public int computeSum() {
		int total = 0;
		for (int score : record) {
			total += score;
		}
		return total;
	}
	
	// 평균을 계산하여 반환하는 메소드
	public double computeAvg() {
		return (double) computeSum() / record.length;
	}
	
	
	// 학점을 계산하여 반환하는 메소드
	public String computeGrade() {
		int gradeLevel = (int) computeAvg() / 10;
		if (gradeLevel >= 9) return "A";
		else if (gradeLevel == 8) return "B";
		else if (gradeLevel == 7) return "C";
		else if (gradeLevel == 6) return "D";
		else return "F";
	}
	
	
	@Override
	// 학생의 이름으로 같은 레코드인지 판별한다.
	public boolean equals(Object obj) {
		Student other;
		if (obj != null && obj instanceof Student) {
			other = (Student) obj;
			if (this.name != null && this.name.equals(other.getName())) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	// 학생 레코드의 정보를 String 타입으로 반환한다.
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.name).append("\t");
		for (int score : record) {
			result.append(score).append("\t");
		}
		result.append(computeSum()).append("\t");
		result.append(computeAvg()).append("\t");		
		result.append(computeGrade()).append("\t");		
		return result.toString();
	}
	
	
}
