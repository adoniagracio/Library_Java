/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author Adrian
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;

public abstract class Account implements Serializable {
    private String user;
    private String pass;
    ArrayList<Book> BooksBorrowed = new ArrayList<Book>();

    public Account(String user, String pass) {
        System.out.println("Created: " + user);
        this.user = user;
        this.pass = encrypt(pass);
    }

    private String encrypt(String str) {
        // MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // byte[] hash = digest.digest(str.getBytes("UTF-8"));
        // StringBuffer hexString = new StringBuffer();

        // for (int i = 0; i < hash.length; i++) {
        // String hex = Integer.toHexString(0xff & hash[i]);
        // if (hex.length() == 1)
        // hexString.append('0');
        // hexString.append(hex);
        // }
        // return hexString.toString();
        return str;
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

    public void Borrow(LocalDate date, Book book) {
        BooksBorrowed.add(book);
        book.Borrow(this);
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
