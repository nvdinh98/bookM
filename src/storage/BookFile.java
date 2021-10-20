package storage;

import model.Book;

import java.io.*;
import java.util.ArrayList;

public class BookFile {
    private  static BookFile bookFile ;

    public BookFile() {
    }
    public static BookFile getInstance(){
        if (bookFile == null) {
            bookFile = new BookFile();
        }
        return bookFile;
    }

    public static ArrayList<Book> readFile() throws IOException, ClassNotFoundException {
        File file = new File("Book.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() > 0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<Book> list = (ArrayList<Book>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return  new ArrayList<>();
    }
    public  static  void writeFile(ArrayList<Book> books) throws IOException {
        File file;
        FileOutputStream fileOutputStream = new FileOutputStream("Book.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(books);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
