package storage;

import model.CardBook;

import java.io.*;
import java.util.ArrayList;

public class CardBookFile {
    public  static  CardBookFile cardBookFile;

    public CardBookFile() {
    }

    public static CardBookFile getInstance(){
        if (cardBookFile == null){
            cardBookFile = new CardBookFile();
        }
        return cardBookFile;
    }

    public static ArrayList<CardBook> readFile() throws IOException, ClassNotFoundException {
        File file = new File("CardBook.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() > 0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<CardBook> list = (ArrayList<CardBook>) object;
            objectInputStream.close();
            fileInputStream.close();
            return  list;
        }
        else return new  ArrayList<>();
    }
    public static void writerFile(ArrayList<CardBook> cardBooks) throws IOException {
        File file;
        FileOutputStream fileOutputStream = new FileOutputStream("CardBook.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(objectOutputStream);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
