package storage;

import model.Book;
import model.User;

import java.io.*;
import java.util.ArrayList;

public class UserFile {
    public static UserFile userFile;

    public UserFile() {
    }
    public static UserFile getInstance(){
        if (userFile == null){
            userFile = new UserFile();
        }
        return null;
    }

    public static ArrayList<User> readFile() throws IOException, ClassNotFoundException {
        File file = new File("User.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() > 0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            ArrayList<User> list = (ArrayList<User>) obj;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else  return new ArrayList<>();
    }

    public static void writeFile(ArrayList<User> users) throws IOException {
        File file;
        FileOutputStream fileOutputStream = new FileOutputStream("User.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(users);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
