package Day9.workshop.studentWorkshop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


/**
 * The type Asc comparator.
 *
 * @author SYM
 * @information 저장된 Student 객체를 읽어와 성적순(평균기준)으로 오름차순으로 학생정보를 화면으로 출력하는 클래스
 */
//평균성적의 오름차순으로 정렬하기 위한 Compatator 구현 클래스
class AscComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return (int) (o1.computeAvg() - o2.computeAvg());
	}
	
}

/**
 * The type Student output.
 */
public class StudentOutput {

	// 멤버 필드
	private String INPUT_DATA_FILE = "student.dat";
	private Set<Student> recordSet;

	/**
	 * Instantiates a new Student output.
	 */
// 생성자
	public StudentOutput() {
		recordSet = new TreeSet<Student>(new AscComparator());
	}

	/**
	 * Load db records boolean.
	 *
	 * @return the boolean
	 */
// 데이터 저장소로부터 정렬방법이 지정된 recordSet 으로 데이터를 얻어온다.
	public boolean loadDBRecords() {
		
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
	 * Print.
	 */
// recordSet 의 내용을 출력한다.
	public void print() {

		System.out.println("**********************************************************************************************************\n");
		System.out.println("                                         ## 학사 관리 시스템 : 데이터 출력 ##                                         ");
		System.out.println("\n**********************************************************************************************************");
		System.out.println("\t이름\t\t국어\t\t영어\t\t수학\t\t과학\t\t합계\t\t평균\t\t학점");
		System.out.println("**********************************************************************************************************");

		if (recordSet.size() == 0) {
			System.out.println("\n                                                   ※ 데이터가 없습니다.                                          \n");
		} else { 
			for (Student aRecord : recordSet) {
				System.out.println("\t" + aRecord.getName() +"\t\t" 
							+ aRecord.getRecord()[0] + "\t\t"
							+ aRecord.getRecord()[1] + "\t\t"
							+ aRecord.getRecord()[2] + "\t\t"
							+ aRecord.getRecord()[3] + "\t\t"
							+ aRecord.computeSum() + "\t\t"
							+ aRecord.computeAvg() + "\t\t"
							+ aRecord.computeGrade());
			}
		}
		
		System.out.println("**********************************************************************************************************");
		System.out.println("                                                   ##  프로그램 종료 ##                                                   ");
		System.out.println("**********************************************************************************************************");
	}


	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
// 실행을 위한 main 메소드
	public static void main(String[] args) {
		
		StudentOutput output = new StudentOutput();
		output.loadDBRecords();
		output.print();
		
	}
}


