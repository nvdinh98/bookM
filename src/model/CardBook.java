package model;

import java.io.Serializable;
import java.time.LocalDate;

public class CardBook implements Serializable {
    private Student student;
    private Book book;
    private LocalDate borrowedDate;
    private LocalDate payDate;

    public CardBook() {
    }

    public CardBook(Student student, Book book, LocalDate borrowedDate, LocalDate payDate) {
        this.student = student;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.payDate = payDate;
    }

    public CardBook(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "CardBook{" +
                "student=" + student +
                ", book=" + book +
                ", borrowedDate=" + borrowedDate +
                ", payDate=" + payDate +
                '}';
    }
}
