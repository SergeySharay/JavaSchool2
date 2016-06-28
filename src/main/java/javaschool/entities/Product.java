package javaschool.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product", schema = "client")
@NamedQueries({

        @NamedQuery(name = "Product.getProducts", query = "SELECT P from Product P"),
        @NamedQuery(name = "Product.getProductsInCollection", query = "SELECT P from Product P where P.brand=:brand and P.collection=:collection"),
        @NamedQuery(name = "Product.getBrands", query = "SELECT P.brand from Product P"),
        @NamedQuery(name = "Product.getBrand", query = "SELECT P.brand from Product P where P.collection=:collection"),
        @NamedQuery(name = "Product.getCollections", query = "SELECT P.collection from Product P where P.brand = :brand"),
        @NamedQuery(name = "Product.getAllCollections", query = "SELECT P.collection from Product P"),
        @NamedQuery(name = "Product.getColors", query = "SELECT P.color from Product P")

})
public class Product implements Serializable {
    private Long id;
    private String category;
    private String brand;
    private String collection;
    private String name;
    private String color;
    private String picture;
    private Long price;
    private Long length;
    private Long width;
    private Long weight;
    private Long quantity;
    private Set<OrderProduct> orderProduct = new HashSet<OrderProduct>();

    public Product() {
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

    @OneToMany(targetEntity = OrderProduct.class, mappedBy = "productId", fetch = FetchType.EAGER)
    public Set<OrderProduct> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Set<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }

    @Column(name = "product_category", length = 100)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "product_brand", length = 100)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "product_collection", length = 100)
    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    @Column(name = "product_name", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "product_color", length = 100)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "product_picture", length = 100)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Column(name = "product_price", length = 10)
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Column(name = "product_length", length = 10)
    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    @Column(name = "product_width", length = 10)
    public Long getWidth() {
        return width;
    }

    public void setWidth(Long witdh) {
        this.width = witdh;
    }

    @Column(name = "product_weight", length = 10)
    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long veight) {
        this.weight = veight;
    }

    @Column(name = "product_quantity", length = 10)
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
