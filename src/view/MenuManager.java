package view;

import controler.StudentManager;

import java.util.Scanner;

public class MenuManager {

    public MenuManager() {
    }
    public static class MenuManagerHelper{
        private static final MenuManager INSTANCE = new MenuManager();
    }
    public static MenuManager getInstance(){
        return  MenuManagerHelper.INSTANCE;
    }

    public void runMenu(){
        StudentMenu studentMenu = new StudentMenu();
        BookMenu bookMenu = new BookMenu();
        CardBookMenu cardBookMenu = new CardBookMenu();

        Scanner number = new Scanner(System.in);
        int choice = -1;
    do {
        System.out.println("nhap so trong menu muon chon");
        choice = number.nextInt();
        switch (choice){
            case 1:
                studentMenu.runStudent();
                break;
            case 2:
                bookMenu.
        }
    }while (choice != -1);
    }
    public  void menu(){
        System.out.println("---------Library HomePage-------");
        System.out.println("1.quan ly sinh vien");
        System.out.println("2.quan ly sach");
        System.out.println("3.quan ly the thu vien");
        System.out.println("4.Exit");

    }
}
