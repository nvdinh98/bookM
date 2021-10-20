package controler;

import model.Student;
import storage.StudentFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> studentArrayList = new ArrayList<>();
    StudentFile studentFile = StudentFile.getInstance();


    public StudentManager() {
    }

    public static class StudentManagerHelper {
        private static final StudentManager INSTANCE = new StudentManager();
    }

    public static StudentManager getInstance() {
        return StudentManagerHelper.INSTANCE;
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) throws IOException {
        this.studentArrayList = studentArrayList;
        StudentFile.writeFile(getStudentArrayList());
    }

    //hien thi danh sach sinh vien

    public void showAllStudent() {
        for (Student student : studentArrayList
        ) {
            System.out.println(student);
        }
    }

    // tim sv theo code tra ve student.
    public Student findStudentByCode(String code) {
        Student student = null;
        for (Student studentList : studentArrayList
        ) {
            if (studentList.getStudentCode().equals(code)) {
                student = studentList;
                break;
            }
        }
        return student;
    }

    // add Student
    public void addStudent(Student student) throws IOException {
        studentArrayList.add(student);
        StudentFile.writeFile(getStudentArrayList());
    }

    // sua thong tin sinh vien theo code
    public void editStudent(String code, Student newStudent) throws IOException {
        Student student = findStudentByCode(code);
        if (student != null) {
            inputStudent(student);
        } else {
            System.out.println("khong tim thay sinh vien");
        }
        StudentFile.writeFile(studentArrayList);
    }

    // xoa sinh vien
    public void removeStudent(String code) throws IOException {
        Student student = findStudentByCode(code);
        if (student != null) {
            for (int i = 0; i < studentArrayList.size(); i++) {
                if (studentArrayList.get(i).equals(student)) {
                    studentArrayList.remove(i);
                }
            }
        } else {
            System.out.println("khong tim thay hoc sinh");
        }
        StudentFile.writeFile(getStudentArrayList());
    }

    private void inputStudent(Student student) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("nhap lai thong tin sinh vien");
        System.out.println("nhap ten sinh vien");
        String name = sc1.nextLine();
        System.out.println("nhap ma so sinh vien");
        String studentCode = sc1.nextLine();
        System.out.println("nhap tuoi sinh vien");
        String age = sc1.nextLine();
        System.out.println("nhap lop ");
        String classRoom = sc1.nextLine();
        System.out.println("nhap so tien hien co");
        double balance = sc1.nextDouble();
        student.setName(name);
        student.setStudentCode(studentCode);
        student.setAge(age);
        student.setClassRoom(classRoom);
        student.setBalance(balance);
    }
}
