package javaschool.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "orders", schema = "client")
@NamedQueries({
        @NamedQuery(name = "Orders.getOrders", query = "SELECT O from Orders O"),
        @NamedQuery(name = "Orders.getClientOrders", query = "SELECT O.id from Orders O where client=:client"),
        @NamedQuery(name = "Orders.getBucket", query = "SELECT O.id from OrderProduct O where orderId=:orderId")
})

public class Orders implements Serializable {

    private Long id;
    private Client client;
    private String payment;
    private String delivery;
    private String paymentStatus;
    private String orderStatus;
    private Date orderDate;
    private Set<OrderProduct> bucket = new LinkedHashSet<OrderProduct>();

    public Orders() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 10, unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @OneToMany(targetEntity = OrderProduct.class, mappedBy = "orderId", fetch = FetchType.EAGER)
    public Set<OrderProduct> getBucket() {
        return bucket;
    }

    public void setBucket(Set<OrderProduct> bucket) {
        this.bucket = bucket;
    }

    @Column(name = "payment", length = 100)
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Column(name = "delivery", length = 100)
    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    @Column(name = "payment_status", length = 100)
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Column(name = "order_status", length = 50)
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Column(name = "order_date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


}