package Day9.workshop.studentWorkshop;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


/**
 * The type Desc comparator.
 *
 * @author SYM
 * @information 객체로 저장된 Student를 읽어와 평균으로 성적을 오름차순으로 orderByAvg.dat파일에 쓰는 클래스
 * @condition 조건 ) 정렬시 TreeSet과 compator 인터페이스를 이용하여 구현하세요.
 */
//평균성적의 내림차순으로 정렬하기 위한 Compatator 구현 클래스
class DescComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return (int) (o2.computeAvg() - o1.computeAvg());
	}
	
}


/**
 * The type Sorted student.
 */
public class SortedStudent {

	// 멤버 필드
	private String INPUT_DATA_FILE = "student.dat";
	private String RESULT_DATA_FILE = "orderByAvg.dat";
	private Set<Student> recordSet;

	/**
	 * Instantiates a new Sorted student.
	 */
// 생성자
	public SortedStudent() {
		recordSet = new TreeSet<Student>(new DescComparator());
	}


	/**
	 * Load origin records boolean.
	 *
	 * @return the boolean
	 */
// 데이터 저장소로부터 평균점수의 내림차순으로 정렬되도록 지정된 recordSet 에 레코드를 읽어온다.
	public boolean loadOriginRecords() {

		ObjectInputStream in = null;
		Student aRecord;

		try {

			in = new ObjectInputStream(new FileInputStream(INPUT_DATA_FILE));

			while (true) {
				aRecord = (Student) in.readObject();
				recordSet.add(aRecord);
			}

		} catch (FileNotFoundException e) {
			System.out.println("데이터 파일이 존재하지 않습니다.");
			return false;
		}  catch (Exception e) { 
			// ClassNotFound, IOException 대해 : 더이상 읽을 데이터가 없으므로 다음 처리를 finally 절로 이동.
		} finally {
			try { if (in != null) in.close(); } catch (IOException e) { }
		}

		return true;


	}

	/**
	 * Save ordered records boolean.
	 *
	 * @return the boolean
	 */
// orderByAvg.dat 파일에 recordSet 의 데이터를 기록한다.
	public boolean saveOrderedRecords() {

		ObjectOutputStream out = null;

		try {

			out = new ObjectOutputStream(new FileOutputStream(RESULT_DATA_FILE));

			for (Student aRecord : this.recordSet) {
				out.writeObject(aRecord);
			}

		} catch (FileNotFoundException e) {
			System.err.println("에러 : " + e.getMessage());
			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try { if (out != null) out.close(); } catch (IOException e) { }
		}
		return true;
	}


	/**
	 * Print.
	 */
// recordSet 의 내용을 출력한다.
	public void print() {

		System.out.println("************************************************************************************************************************\n");
		System.out.println("                                               ## 학사 관리 시스템 : 평균성적 순위 출력 ##                                           ");
		System.out.println("\n************************************************************************************************************************");
		System.out.println("\t이름\t\t국어\t\t영어\t\t수학\t\t과학\t\t합계\t\t평균\t\t학점\t\t순위");
		System.out.println("************************************************************************************************************************");

		if (recordSet.size() == 0) {
			System.out.println("\n                                                        ※ 데이터가 없습니다.                                          \n");
		} else { 
			int i = 1;
			for (Student aRecord : recordSet) {
				System.out.println("\t" + aRecord.getName() +"\t\t" 
						+ aRecord.getRecord()[0] + "\t\t"
						+ aRecord.getRecord()[1] + "\t\t"
						+ aRecord.getRecord()[2] + "\t\t"
						+ aRecord.getRecord()[3] + "\t\t"
						+ aRecord.computeSum() + "\t\t"
						+ aRecord.computeAvg() + "\t\t"
						+ aRecord.computeGrade() + "\t\t" + i++);
			}
		}

		System.out.println("************************************************************************************************************************");
		System.out.println("                                                          ##  프로그램 종료 ##                                                            ");
		System.out.println("************************************************************************************************************************");
	}


	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
// 실행을 위한 메인 메소드
	public static void main(String[] args) {
		
		SortedStudent sorted = new SortedStudent();
		
		sorted.loadOriginRecords();
		if (sorted.saveOrderedRecords()) {
			sorted.print();
		}
		
	}
	


}



