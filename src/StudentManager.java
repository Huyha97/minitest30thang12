import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    public static final String PATH_NAME = "C:\\Users\\This MC\\Desktop\\minitest30.12\\src\\students.txt";
    private ArrayList<Student> students = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public StudentManager() {
        this.students = readFile(PATH_NAME);
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public Student creatStudent() {
        System.out.println("input id");
        int id = scanner.nextInt();
        System.out.println("input name: ");
        String name = scanner.next();
        System.out.println("input age: ");
        int age = scanner.nextInt();
        System.out.println("input MathPoint: ");
       double MathPoint = scanner.nextDouble();
        System.out.println("input PhysicsPoint: ");
        double PhyPoint = scanner.nextDouble();
        System.out.println("input ChemPoint: ");
        double ChemPoint = scanner.nextDouble();
        scanner.nextLine();
        return new Student(id,name, age, MathPoint,PhyPoint,ChemPoint);
    }

    public void addStudent(Student student) {
        students.add(student);
        writeFile(students, PATH_NAME);
        System.out.println("Add successfully!");
    }

    public Student editStudent(int id) {
        Student student = null;
        for (Student s : students) {
            if (s.getId()==id) {
                student = s;
            }
        }
        if (student != null) {
            int index = students.indexOf(student);
            System.out.println("input name: ");
            String name1 = scanner.next();
            student.setName(name1);
            System.out.println("input age: ");
            int age = scanner.nextInt();
            student.setAge(age);
            System.out.println("input MathPoint: ");
            double MathPoint = scanner.nextDouble();
            student.setMathPoint(MathPoint);
            System.out.println("input PhysicsPoint: ");
            double PhyPoint = scanner.nextDouble();
            student.setPhyPoint(PhyPoint);
            System.out.println("input ChemPoint: ");
            double ChemPoint = scanner.nextDouble();
            student.setChemPoint(ChemPoint);
            scanner.nextLine();
            writeFile(students, PATH_NAME);
            System.out.println("Update student successfully!");
        }
        return student;
    }

    public Student deleteStudent(String name) {
        Student student = null;
        for (Student s : students) {
            if (s.getName().equals(name)) {
                student = s;
            }
        }
        if (student != null) {
            students.remove(student);
            writeFile(students,PATH_NAME);
            System.out.println("Delete student have name = \" + name + \" successfully!");
        }
        return student;
    }

    public void displayAll() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public ArrayList<Student> getStudentsByMaxPoint() {
        ArrayList<Student> studentsMax = new ArrayList<>();
        double avg = students.get(0).getAvgPoint();
        for (Student s : students) {
            if (s.getAvgPoint() > avg) {
                avg = s.getAvgPoint();
            }
        }
        for (Student s : students) {
            if (s.getAvgPoint() == avg) {
                studentsMax.add(s);
            }
        }
        return studentsMax;
    }

    public ArrayList<Student> sortByAvgPointDecrease() {
        students.sort((o1, o2) -> Double.compare(o2.getAvgPoint(), o1.getAvgPoint()));
        return students;
    }

    public ArrayList<Student> sortByAvgPointIncrease() {
        students.sort((o1, o2) -> Double.compare(o1.getAvgPoint(), o2.getAvgPoint()));
        return students;
    }



    public void writeFile(ArrayList<Student> students, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (Student student : students) {
                bufferedWriter.write(student.getId() + student.getName() + "," + student.getAge() + ","
                        + student.getMathPoint() + "," + student.getPhyPoint() + "," + student.getChemPoint() +"\n");
            }
            bufferedWriter.close();
            System.out.println("Write file successfully!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Student> readFile(String path) {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(PATH_NAME);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                students.add(new Student(Integer.parseInt(strings[0]),strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3]),
                        Double.parseDouble(strings[4]), Double.parseDouble(strings[5])));
            }

        } catch (Exception e) {
            System.err.println();
        }
        return students;
    }


}
