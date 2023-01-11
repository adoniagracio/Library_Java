/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author Adrian
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;

public class Book implements Serializable {
    public String isbn;
    public String title;
    public String author;
    private Account borrower = null;
    private LocalDate dueDate = null;

    public ArrayList<String> genre = new ArrayList<String>();

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public void Borrow(Account borrower) {
        this.borrower = borrower;
        LocalDate currentDate = LocalDate.now();
        dueDate = currentDate.plusDays(14);
    }

    public void Return() {
        this.borrower = null;
        dueDate = null;
    }

    public String getISBN() {
        return this.isbn;
    }

    public String getAuthor(){
        return this.author;
    }

    public Boolean getStatus(){
        return (borrower == null);
    }

    public String getTitle() {
        return this.title;
    }

    public Account getBorrower() {
        return borrower;
    }

    public LocalDate getDue() {
        return dueDate;
    }
}