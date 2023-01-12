/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author Adrian
 */
import java.util.ArrayList;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

public abstract class Account implements Serializable {
    private String user;
    private String pass;
    ArrayList<Book> BooksBorrowed = new ArrayList<Book>();
    private SimpleDateFormat issueDate;
    private SimpleDateFormat returnDate;

    public Account(String user, String pass) {
        System.out.println("Created: " + user);
        this.user = user;
        this.pass = encrypt(pass);
    }

    public void update(String user){
        this.user = user;
    }

    public static String encrypt(String pass){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(pass.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean check(String user, String pass) {
        System.out.println("Checking " + user + " == " + this.user);
        if(user.equals(this.user))
            System.out.println("    " + pass + " with " + this.pass);
        if(((user.equals(this.user)) && (encrypt(pass).equals(this.pass))))
            System.out.println("====Found!====");
        return ((user.equals(this.user)) && (encrypt(pass).equals(this.pass)));
    }

    public String getName() {
        return this.user;
    }
    
    public void changePass(String pass){
      this.pass = encrypt(pass);  
    }

    public void BorrowBook(SimpleDateFormat date, Book book) {
        this.issueDate = date;
        BooksBorrowed.add(book);
        book.Borrow(this);
    }

    public void ReturnBook(Book book){
        if(BooksBorrowed.contains(book)){
            BooksBorrowed.remove(book);
            book.Return();
        }
        else{
            System.out.println("Book not found in the Borrowed list!");
        }
    }

    public ArrayList<Book> getBooks() {
        return BooksBorrowed;
    }

    public boolean isAdmin(){
        return false;
    }

    public String getNIM(){
        return "";
    }

    public String getEmail(){
        return "";
    }

    public String getNick(){
        return "";
    }

}
