import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("⓿ ❶ ❷ ❸ ❹ ❺ ❻ ❼ ❽ ❾ ❿ -----MENU------ ⓫ ⓬ ⓭ ⓮ ⓯ ⓰ ⓱ ⓲ ⓳ ⓴");
            System.out.println("  1. Add student  ");
            System.out.println("  2. Delete student by id     ");
            System.out.println("  3. Edit student by id       ");
            System.out.println("  4. Display all Student      ");
            System.out.println("  5. Display all student by maxPoint   ");
            System.out.println("  6. Sort student decrease by averagePoint   ");
            System.out.println("  7. Sort student increase by averagePoint  ");
            System.out.println("  8. Write file                             ");
            System.out.println("  9. Read File                               ");
            System.out.println("  0. Exit                                    ");
            System.out.println("  Input your choice:                         ");
            System.out.println("ㄱ ㄲ ㄳ ㄴ ㄵ ㄶ ㄷ ㄸ ㄹ ㄺ ㄻ ㄼ ㄽ ㄾ ㄿ ㅀ ㅁ ㅂ ㅃ ㅄ ㅅ ㅆ ㅇ ㅈ  ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Student student = studentManager.creatStudent();
                    studentManager.addStudent(student);
                    break;
                case 2:
                    System.out.println(" input student name want to delete");
                    String deleteName = scanner.next();
                    Student studentDelete = studentManager.deleteStudent(deleteName);
                    System.out.println(studentDelete);
                    break;
                case 3:
                    System.out.println(" input id student  want to edit");
                    int editId = scanner.nextInt();
                    Student editStudent = studentManager.editStudent(editId);
                    System.out.println(editStudent);
                    break;
                case 4:
                    studentManager.displayAll();
                    break;
                case 5:
                    ArrayList<Student> studentMax = studentManager.getStudentsByMaxPoint();
                    studentMax.forEach(System.out::println);
                    break;
                case 6:
                    ArrayList<Student> students = studentManager.sortByAvgPointDecrease();
                    students.forEach(System.out::println);
                    break;
                case 7:
                    ArrayList<Student> students1 = studentManager.sortByAvgPointIncrease();
                    students1.forEach(System.out::println);
                    break;
                case 8:
                    studentManager.writeFile(studentManager.getStudents(), StudentManager.PATH_NAME);
                    break;
                case 9:
                    ArrayList<Student> studentList = studentManager.readFile(StudentManager.PATH_NAME);
                    studentList.forEach(System.out::println);
                    break;
            }
        } while (choice !=0);
    }
}

