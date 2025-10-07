//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Ivanov Ivan", 19, "programming", 2, 4.5 );
        Teacher teacher = new Teacher("Dobronravov I. N.", 45, "Programming", 15, "Information technology");
        Assistant assistant = new Assistant("Lebedev Robin", 23, "Economics", 45);
        //Scanner scanner = new Scanner(System.in);
        //String studentname = scanner.nextLine();
        //String specialitystudent = scanner.nextLine();
        //double score = scanner.nextDouble();
        //scanner.nextLine();
        //int year = scanner.nextInt();
        //int age = scanner.nextInt();
        //Student student = new Student(studentname, age, specialitystudent, year,);
        //student.setScore(score);

        System.out.println("Student");
        student.work();
        student.status();
        student.statud();
        System.out.println(student.getSpeciality());
        student.setSpeciality("Engineering");
        System.out.println(student.getSpeciality());

        System.out.println("Teacher");
        teacher.work();
        teacher.status();
        teacher.teaching();

        System.out.println("Assistant");
        assistant.work();
        assistant.status();
        assistant.sprcificWork();

        System.out.println("Polymorphism");
        Person[] persons={student, teacher, assistant};
        for (Person person : persons) {
            person.work();
            person.status();
        }
        System.out.println(Person.getCount());

        System.out.println("Encapsulation");
        assistant.setScopeOfWork(-100);
        System.out.println(assistant.getScopeOfWork());
    }
    
}
