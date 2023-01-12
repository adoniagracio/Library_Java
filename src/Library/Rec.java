package Library;

import java.text.SimpleDateFormat;

public class Rec {
    private String UserID;
    private String BookTitle;
    private String username;
    private SimpleDateFormat issueDate;
    private SimpleDateFormat returnDate;

    public Rec(String UserID, String BookTitle, String username, SimpleDateFormat issueDate, SimpleDateFormat returnDate){
        this.UserID = UserID;
        this.BookTitle = BookTitle;
        this.username = username;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }
    
    public String getUserID(){
        return this.UserID;
    }
    public String getBookTitle(){
        return this.BookTitle;
    }
    public String getUsername(){
        return this.username;
    }
    public SimpleDateFormat getissueDate(){
        return this.issueDate;
    }
    public SimpleDateFormat getreturnDate(){
        return this.returnDate;
    }
}