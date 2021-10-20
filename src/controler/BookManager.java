package controler;

import model.Book;
import storage.BookFile;

import java.io.IOException;
import java.util.ArrayList;

public class BookManager {
    ArrayList<Book> bookArrayList = new ArrayList<>();
    BookFile bookFile = BookFile.getInstance();

    public BookManager() {
    }

    public static class BookManagerHelper {
        private static final BookManager INSTANCE = new BookManager();
    }

    public static BookManager getInstance(){
        return BookManagerHelper.INSTANCE;
    }
    public BookManager(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }


    // hien thi danh sach book
    public void showAllBook() {
        for (Book book : bookArrayList
        ) {
            System.out.println(book);
        }
    }

    //tim kiem book

    public Book findBookByCode(String newCode) {
        for (Book book : bookArrayList
        ) {
            if (book.getBookCode().equals(newCode)) ;
            return book;
        }
        return null;
    }

    //add book
    public void addBook(Book book) throws IOException {
        bookArrayList.add(book);
        BookFile.writeFile(bookArrayList);
    }

    //sua thong tin theo code
    public void editBook(String code, Book newBook) throws IOException {
        Book book = findBookByCode(code);
        if (book != null) {
            for (int i = 0; i < bookArrayList.size(); i++) {
                if (bookArrayList.get(i).equals(book)) {
                    bookArrayList.set(i, newBook);
                }
            }
        } else {
            System.out.println("khong tim thay sach");
        }
        BookFile.writeFile(bookArrayList);
    }

    public void removeBook(String code) throws IOException {
        Book book = findBookByCode(code);
        if (book != null) {
            for (int i = 0; i < bookArrayList.size(); i++) {
                if (bookArrayList.get(i).equals(book)) {
                    bookArrayList.remove(i);
                }
            }
        } else {
            System.out.println("khong tim thay ");
        }
        BookFile.writeFile(bookArrayList);
    }

}
