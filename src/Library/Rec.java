package Library;

import java.time.LocalDate;

public class Rec implements Serializable{
    private String UserID;
    private String isbn;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Rec(String UserID, String isbn, LocalDate issueDate, LocalDate returnDate){
        this.UserID = UserID;
        this.isbn = isbn;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }
    
    public String getUserID(){
        return this.UserID;
    }
    public String getISBN(){
        return this.isbn;
    }
    public LocalDate getissueDate(){
        return this.issueDate;
    }
    public LocalDate getreturnDate(){
        return this.returnDate;
    }
}