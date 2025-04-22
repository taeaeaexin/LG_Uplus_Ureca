package app.book.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Book {
    @Id
    private int bookId;
    private String bookName;
    private String publisher;
    private int price;
    
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", publisher=" + publisher + ", price=" + price
                + "]";
    }
}
