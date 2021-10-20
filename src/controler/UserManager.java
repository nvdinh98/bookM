package controler;

import model.User;
import storage.UserFile;

import java.io.IOException;
import java.util.ArrayList;

public class UserManager {
    ArrayList<User> userArrayList = new ArrayList<>();
    UserFile userFile = UserFile.getInstance();

    public UserManager() {
    }
    public static class UserManagerHelper {
        private static final UserManager INSTANCE  = new UserManager();
    }
    public static UserManager getInstance(){
        return  UserManagerHelper.INSTANCE;
    }


    public UserManager(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public void addNewUser(User user) throws IOException {
        userArrayList.add(user);
        UserFile.writeFile(userArrayList);
    }
    public void removeUser(int index){
        userArrayList.remove(index);
    }
    public void editUser(int index,User user){
        userArrayList.set(index,user);
    }
    public  boolean isLogin(User userLogin){
        for (User user : userArrayList
             ) {
            if (user.getAccount().equals(userLogin.getAccount()) &&  user.getPassWord().equals(userLogin.getPassWord()));
            return true;
        }
        return false;
    }
}
