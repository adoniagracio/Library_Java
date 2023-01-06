/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author Adrian
 */
public class User extends Account {
    public User(String name, String pass) {
        super(name, pass);
    }

    void menu() { // !harus ada, karena di parent ada abstract menu()
        System.out.print("User menu!\n");
    }
}