package entity;
import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;    
    
    
    @Column(name = "order_quantity")
    private int orderQuantity;
    
    @Column(name = "order_date")
    private LocalDate orderDate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
        
    public int getOrderQuantity() {
        return orderQuantity;
    }
    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
    
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    // #2
    // Customer, Product 없는 toString()
    @Override
    public String toString() {
        return "Orders [id=" + id + ", orderQuantity=" + orderQuantity + ", orderDate=" + orderDate + "]";
    }
    // Customer 없는 toString
//  @Override
//  public String toString() {
//      return "Orders [id=" + id + ", product=" + product + ", orderQuantity="
//              + orderQuantity + ", orderDate=" + orderDate + "]";
//  }
//  @Override
//  public String toString() {
//      return "Orders [id=" + id + ", customer=" + customer + ", product=" + product + ", orderQuantity="
//              + orderQuantity + ", orderDate=" + orderDate + "]";
//  }
}