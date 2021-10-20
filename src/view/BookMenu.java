package view;

import controler.BookManager;
import model.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class   BookMenu {
    public void runBook() throws IOException {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = BookManager.getInstance();

        int choice = -1;
        do {
            System.out.println("nhap so muon chon trong menu");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    bookManager.addBook(inputBook());
                    break;
                case 2:
                    bookManager.editBook(inputBookCode(),inputBook());
                    break;
                case 3:
                    bookManager.removeBook(inputBookCode());
                    break;
                case 4:
                    bookManager.findBookByCode(inputBookCode());
                    break;
                case 5:
                    bookManager.showAllBook();
                    break;
                case 0:

            }
        }while (choice != -1);


    }
    public void menu(){
        System.out.println("--------Quản lý sách trong thư viện--------");
        System.out.println("1. Thêm sách");
        System.out.println("2. Sửa thông tin sách");
        System.out.println("3. Xóa sinh sách");
        System.out.println("4. Tìm kiếm theo mã sách");
        System.out.println("5. Dách sách Sách");
        System.out.println("0. Quay lại");
    }
    // them sach
    public void addNewBook(BookManager bookManager) throws IOException {
        bookManager.addBook(inputBook());
    }

    public static  Book inputBook(){
        System.out.println("nhap thong tin sach");
        Scanner inputBook = new Scanner(System.in);
        System.out.println("nhap ten sach");
        String bookCode;
        String name;
        int quantity;
        System.out.println("nhap ma sach");
        bookCode = inputBook.nextLine();
        System.out.println("nhap ten sach");
        name = inputBook.nextLine();
        System.out.println("nhap so luong sach muon");
        quantity = inputBook.nextInt();
        return new Book(bookCode,name,quantity,true);
    }

    public String inputBookCode(){
        System.out.println("nhap ma so sach");
        Scanner inputCode = new Scanner(System.in);
        return inputCode.nextLine();
    }
}
