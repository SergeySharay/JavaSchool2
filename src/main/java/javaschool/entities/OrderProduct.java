package javaschool.entities;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "order_product", schema = "client")
@NamedQueries({
        @NamedQuery(name = "OrderProduct.getOrderProducts", query = "SELECT O from OrderProduct O where orderId=:order"),
        @NamedQuery(name = "OrderProduct.getAllOrderProduct", query = "SELECT O from OrderProduct O")
})
public class OrderProduct implements Serializable {
    private Long Id;
    private Orders orderId;
    private Product productId;
    private Long quantity;

    public OrderProduct() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 10)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Column(name = "quantity", length = 10)
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
