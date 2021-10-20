package Login;

import controler.UserManager;
import model.User;
import storage.UserFile;

import java.io.IOException;
import java.util.Scanner;

public class UserMenu {
    UserManager userManager = new UserManager();
    Scanner scanner = new Scanner(System.in);


    public void runUser() throws IOException, ClassNotFoundException {
        userManager.setUserArrayList(UserFile.getInstance().readFile());
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("nhap so muon chon");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    Scanner inputLogin = new Scanner(System.in);
                    System.out.println("ĐĂNG NHẬP");
                    System.out.print("Tài khoản : ");
                    String userName = inputLogin.nextLine();
                    System.out.print("Mật khẩu : ");
                    String password = inputLogin.nextLine();
                    User userLogin = new User(userName, password);
                    if (userManager.isLogin(userLogin)){
                    // doan nay con thieu.
                    } else {
                        System.out.println("tai khoan hoac mat lhau khong chinh xac");
                    }
                case 2:
                    userManager.addNewUser(inputUser());
                    System.out.println("Da tao tai khoan thanh cong");
                    break;
                case 0:


            }

        }while (choice != 0);
    }
    public void menu(){
        System.out.println("--------Menu Dang Nhap--------");
        System.out.println("1. Dang Ki");
        System.out.println("2. Dang Nhap");
        System.out.println("3. EXit");
    }
    private static User inputUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên đăng nhập: ");
        String user = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String passWord = scanner.nextLine();
        return new User(user,passWord);
    }

}