package Day9.workshop.studentWorkshop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Student input.
 *
 * @author SYM
 * @information 콘솔로부터 학생의 정보를 입력받아 student.dat 파일에 저장하는 클래스
 */
public class StudentInput {
	
	// 멤버 필드
	private String INPUT_DATA_FILE = "student.dat";
	private BufferedReader reader;
	private List<Student> recordSet;


	/**
	 * Instantiates a new Student input.
	 */
// 생성자
	public StudentInput() {
		this.recordSet = new ArrayList<Student>();
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}


	/**
	 * Ready boolean.
	 *
	 * @return the boolean
	 */
// 데이터 저장소로부터 모든 레코드를 읽어온다
	public boolean ready()  {  // loadDBRecoreds()
		ObjectInputStream in = null;	
		File dataFile = null;
		
		try {
			dataFile = new File(INPUT_DATA_FILE);
			
			if (!dataFile.exists()) {
				dataFile.createNewFile();
			}
			
			in = new ObjectInputStream(new FileInputStream(dataFile));
			
			
			while(true) {
				this.recordSet.add((Student) in.readObject());
			}		
			
		} catch (FileNotFoundException e) {
			System.err.println("에러 : " + e.getMessage());
			return false;
		} catch (Exception e) { 
			 // ClassNotFound, IOException 대해 : 더이상 읽을 데이터가 없으므로 다음 처리를 finally 절로 이동.
		} finally {
			try { if (in != null) in.close(); } catch (IOException e) { }
		}
		return true;	
	}

	/**
	 * Release boolean.
	 *
	 * @return the boolean
	 */
// 데이터 저장소에 입력받은 레코드를 저장
	public boolean release() {  // saveDBRecords()
		ObjectOutputStream out = null;
		
		try {
			
			out = new ObjectOutputStream(new FileOutputStream(INPUT_DATA_FILE));
			
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
			try { if (this.reader != null) this.reader.close(); } catch (IOException e) { }
			try { if (out != null) out.close(); } catch (IOException e) { }
		}
		return true;
	}


	/**
	 * Gets record string.
	 *
	 * @return the record string
	 */
// 콘솔로부터 문자열을 입력받아서 반환해준다. (예외처리를 노출시키지 않음.)
	public String getRecordString() {	
		String recordString = null;
		
		try {
			recordString = this.reader.readLine();
		} catch (IOException e) {  // e.printStackTrace();
			return null;
		} 	
		return recordString;	
	}

	/**
	 * String to student student.
	 *
	 * @param source the source
	 * @return the student
	 */
// 콘솔로부터 문자열을 입력받아서 Student 타입의 객체를 반환해주는 메소드
	public Student stringToStudent(String source) {

		if (source == null || source.equals(""))
			return null;
		
		String[] datas = source.split(",");

		int[] scores = new int[datas.length - 1];
		String name = datas[0];

		for (int i = 1; i < datas.length; i++) {
			scores[i - 1] = Integer.parseInt(datas[i].trim());
		}

		return new Student(name, scores);

	}

	/**
	 * Put record.
	 *
	 * @param record the record
	 */
// 새로운 레코드를 recordSet 에 담는다.
	public void putRecord(Student record) {
		this.recordSet.add(record);
	}


	/**
	 * Score validate ok boolean.
	 *
	 * @param student the student
	 * @return the boolean
	 */
// 입력된 학생 레코드의 점수가 유효한 지 확인
	public boolean scoreValidateOk (Student student) {
		for (int score : student.getRecord()) {
			if (score < 0 || score > 100) {
				System.out.println(" ※ 과목 점수가 올바르지 않습니다. (0점부터 100점 사이)");
				return false;
			}
		}
		return true;
	}

	/**
	 * Name validate ok boolean.
	 *
	 * @param name the name
	 * @return the boolean
	 */
// 중복된 이름인지 확인
	public boolean nameValidateOk (String name) {
		for (Student other : recordSet) {
			if (other.getName().equals(name)) {
				System.out.println(" ※ 사용중인 이름이 있습니다. 중복된 이름을 사용할 수 없습니다.");
				return false;
			}
		}
		return true;
	}

	/**
	 * Format validate ok boolean.
	 *
	 * @param source the source
	 * @return the boolean
	 */
// 입력 형식이 올바른지 확인
	public boolean formatValidateOk (String source) {		
		boolean isOk = false;	
		if (source != null && !"".equals(source)) {	
			String[] datas = source.split(",");			
			if (datas.length == 5) {
	
				try {
		
					// int 타입으로 변환가능한 문자열인지 확인.
					for (int i = 1; i < datas.length; i++) 	Integer.parseInt(datas[i].trim()); 
					isOk = true;
		
				} catch (NumberFormatException e) { }
			}
		}
		if (!isOk) System.out.println(" ※ 입력 형식이 올바르지 않습니다.");
		return isOk;
	}


	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
// 실행을 위한 main 메소드
	public static void main(String[] args) {
		
		Student record;
		String source;
		
		System.out.println("**********************************************************************************************************");
		System.out.println("\n                                                  ## 학사 관리 시스템 ##                                         \n");
		System.out.println("**********************************************************************************************************");
		System.out.println(" ※ 입력 형식 : 이름, 국어점수, 영어점수, 수학점수, 과학점수      ");
		System.out.println("**********************************************************************************************************");
		StudentInput input = new StudentInput();
		input.ready();
			
		while (true) {
			
			System.out.print(" ※ 학생 정보를 입력해 주세요 : ? ");
			source = input.getRecordString();
			
			if ("exit".equals(source)) {
				
				System.out.println("**********************************************************************************************************");
				System.out.println(" ※ 데이터를 저장하고 프로그램을 종료합니다.\n");
				break;
				
			}
			
			if (!input.formatValidateOk(source)) 	continue;
			
			record = input.stringToStudent(source);

			if (!input.nameValidateOk(record.getName())) continue;
			if (!input.scoreValidateOk(record)) continue;
			
			input.putRecord(record);
			
		}	
		
		input.release();
		
		System.out.println("**********************************************************************************************************");
		System.out.println("                                                   ##  프로그램 종료 ##                                                   ");
		System.out.println("**********************************************************************************************************");
			
		
	}

}
