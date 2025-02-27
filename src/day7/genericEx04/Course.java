package day7.genericEx04;

public class Course {

    //Person(사람)이면 등록가능한 Type
    public static void registerCourse1(Applicant<?> applicant){
        System.out.println(applicant.kind.getClass().getSimpleName() + "이 Course1을 등록함");
    }

    //학생만 등록가능
    public static void registerCourse2(Applicant<? extends Student> applicant){
        System.out.println(applicant.kind.getClass().getSimpleName() + "이 Course2을 등록함");
    }

    //직장인(Worker) & 일반인만 등록가능
    public static void registerCourse3(Applicant<? super Worker> applicant){
        System.out.println(applicant.kind.getClass().getSimpleName() + "이 Course3을 등록함");
    }

}
