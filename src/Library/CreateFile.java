/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author acer
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;


public class CreateFile {
    File f = new File("C:\\Users\\acer\\Documents\\Vanessa\\BINUS\\OOP\\File.txt");
    void createFolder(){
        if(!f.exists()){
            f.mkdirs(); 
        }
    }
    
    void readFile() throws IOException{
        try{
           FileReader fr = new FileReader(f + "\\books.txt");
           System.err.println("File exists.");
        } catch(FileNotFoundException ex){
                FileWriter fw = new FileWriter(f + "\\books.txt ");
                System.out.println("File created.");
        }
    }
    
    void addData(String title, String author, String isbn){
        try {
            RandomAccessFile raf = new RandomAccessFile(f + "\\books.txt", "rw");
            raf.writeBytes("Title: " + title);
            raf.writeBytes("Author: " + author);
            raf.writeBytes("ISBN: " + isbn);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(CreateFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    /*
    public static void main(String args[]){
        try{
            File myObj = new File("C:\\Users\\acer\\Documents\\Vanessa\\BINUS\\OOP\\File.txt");
            if(myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            } else System.out.println("File already exists.");
        } catch (IOException e){
            System.out.println("[!] Error.");
            e.printStackTrace();
        }
    }
    */
}
