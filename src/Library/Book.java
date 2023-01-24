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
    private Boolean available = true;
    private Account borrower = null;
    private LocalDate issueDate = null;
    private LocalDate dueDate = null;

    public ArrayList<String> genre = new ArrayList<String>();

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public void Borrow(Account borrower, LocalDate date) {
        this.borrower = borrower;
        System.out.println(this.title + " Borrowed by: " + borrower.getName());
        available = false;
        issueDate = LocalDate.now();
        dueDate = issueDate.plusDays(14);
    }

    public void Return() {
        this.borrower = null;
        issueDate = null;
        dueDate = null;
        available = true;
    }

    public Boolean isAvailable(){
        return this.available;
    }

    public String getISBN() {
        return this.isbn;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public Account getBorrower() {
        return this.borrower;
    }

    public LocalDate getIssue(){
        return this.issueDate;
    }
    public LocalDate getDue(){
        return this.dueDate;
    }
}