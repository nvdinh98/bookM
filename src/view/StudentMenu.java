package view;

import controler.StudentManager;
import model.Student;
import storage.StudentFile;

import java.io.IOException;
import java.util.Scanner;

public class StudentMenu {
    public void runStudent() throws IOException {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = StudentManager.getInstance();
        try {
            studentManager.setStudentArrayList(StudentFile.getInstance().readFile());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("nhap so muon chon trong menu");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    studentManager.addStudent(inputStudent());
                    break;
                case 2:
                    studentManager.editStudent(inputCode(),inputStudent());
                    break;
                case 3:
                    studentManager.removeStudent(inputCode());
                    break;
                case 4:
                    studentManager.findStudentByCode(inputCode());
                    break;
                case 5:
                    studentManager.showAllStudent();
                    break;
                case 0:


            }
        }while (choice != 0);
    }

    public void menu(){
        System.out.println("--------Quản lý sinh viên--------");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Sửa thông tin sinh viên");
        System.out.println("3. Xóa sinh viên");
        System.out.println("4. Tìm kiếm theo mã sinh viên");
        System.out.println("5. Dách sách sinh viên");
        System.out.println("0. Quay lại");
    }

    private void creatStudent(StudentManager studentManager) throws IOException {
        studentManager.addStudent(inputStudent());
    }
    public static Student  inputStudent(){
        Scanner string = new Scanner(System.in);
        Scanner integer = new Scanner(System.in);
        String name;
        String studentCode;
        String age;
        String classroom;
        double balance;

        System.out.println("nhap ten sinh vien");
        name = string.nextLine();
        System.out.println("nhap ma so sinh vien");
        studentCode = string.nextLine();
        System.out.println("nhap tuoi sinh vien");
        age = string.nextLine();
        System.out.println("nhap lop");
        classroom = string.nextLine();
        System.out.println("nhap so tien");
        balance = integer.nextDouble();
        return new Student(name,studentCode,age,classroom,balance);
    }
    private String inputCode(){
        System.out.println("nhap ma so sinh vien");
        Scanner scanner = new Scanner(System.in);
        String  studentCode = scanner.nextLine();
        return studentCode;
    }

}
