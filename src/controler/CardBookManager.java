package controler;

import model.CardBook;
import model.Student;
import storage.CardBookFile;

import java.io.IOException;
import java.util.ArrayList;

public class CardBookManager {
    ArrayList<CardBook> cardBookArrayList = new ArrayList<>();
    CardBookFile cardBookFile = CardBookFile.getInstance();

    private static  final  StudentManager STUDENT_MANAGER = StudentManager.getInstance();
    private static final BookManager BOOK_MANAGER = BookManager.getInstance();


    public CardBookManager() {
    }

    public ArrayList<CardBook> getCardBookArrayList() {
        return cardBookArrayList;
    }

    public void setCardBookArrayList(ArrayList<CardBook> cardBookArrayList) {
        this.cardBookArrayList = cardBookArrayList;
    }
    // tim kiem danh sach theo code
    public CardBook findCardBookByCode(String code){
        Student student = STUDENT_MANAGER.findStudentByCode(code);
        for (CardBook cardBook : cardBookArrayList
             ) {
            if (cardBook.getStudent().equals(student)){
                return cardBook;
            }
        }
        return  null;
    }
    //them card theo code
    public void addCardBook(String code) throws IOException {
        Student student = STUDENT_MANAGER.findStudentByCode(code);
        boolean check = false;
        if (student != null){
            for (CardBook cardBook: cardBookArrayList
                 ) {
                if (cardBook.getStudent().getStudentCode().equals(code)){
                    check = true;
                    System.out.println("sinh vien da co the thu vien");
                }
            }
            if (!check){
                cardBookArrayList.add(new CardBook(student));
            }
        }
        else {
            System.out.println("khong tim thay sinh vien");
        }
        CardBookFile.writerFile(getCardBookArrayList());
    }
    // xoa card theo code:
    public void removeCardBook(String code) throws IOException {
        Student student = STUDENT_MANAGER.findStudentByCode(code);
        if (student != null){
            for (int i = 0; i < cardBookArrayList.size(); i++) {
                if (cardBookArrayList.get(i).getStudent().equals(student)){
                    cardBookArrayList.remove(i);
                }
            }
        } else {
            System.out.println("khong tim thay sinh vien");
        }
        CardBookFile.writerFile(getCardBookArrayList());
    }
    // hien thi danh sach
    public void showAllCardBook(){
        for (CardBook cardBook : cardBookArrayList
             ) {
            System.out.println(cardBook);
        }
    }


}
