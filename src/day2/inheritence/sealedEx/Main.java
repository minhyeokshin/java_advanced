package day2.inheritence.sealedEx;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        Employee employee = new Employee();
        Manager manager = new Manager();
        Student student = new Student();

        person.work();
        employee.work();
        manager.work();
        student.work();
    }
}
