package Library;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author adoni
 */
public class Koneksi {
    Connection Koneksi = null;
    public static Connection koneksiDB(){
        try{
          Class.forName("com.mysql.jdbc.Driver");
            Connection Koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        return Koneksi;
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
}
}
