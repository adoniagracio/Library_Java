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
    private String name;
    private String pass;
    ArrayList<Book> BooksBorrowed = new ArrayList<Book>();

    public Account(String name, String pass) {
        this.name = name;
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

    public boolean check(String name, String pass) {
        System.out.println("Checking " + name + " == " + this.name);
        if(name.equals(this.name))
            System.out.println("    " + pass + " with " + this.pass);
        return ((name.equals(this.name)) && (encrypt(pass).equals(this.pass)));
    }

    public String getName() {
        return this.name;
    }

    public void Borrow(LocalDate date, Book book) {
        BooksBorrowed.add(book);
        book.Borrow(this);
    }

    public ArrayList<Book> getBooks() {
        return BooksBorrowed;
    }

    abstract void menu();
}
