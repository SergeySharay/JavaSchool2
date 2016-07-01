package javaschool.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client_adress", schema = "client")
@NamedQuery(name = "ClientAdress.getAdress", query = "SELECT C from ClientAddress C where client=:client")

public class ClientAddress implements Serializable {
    private Long clientAdressId;
    private Client client;
    private String country;
    private String city;
    private String street;
    private String house;
    private String flat;
    private Long zipcode;

    public ClientAddress() {
    }

    public ClientAddress(Client client) {
        this.client = client;
        this.country = null;
        this.city = null;
        this.street = null;
        this.house = null;
        this.flat = null;
        this.zipcode = null;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 10, unique = true, nullable = false)
    public Long getId() {
        return clientAdressId;
    }

    public void setId(Long id) {
        this.clientAdressId = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Column(name = "client_adress_country", length = 100)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "client_adress_city", length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "client_adress_street", length = 100)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "client_adress_house", length = 10)
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Column(name = "client_adress_flat", length = 10)
    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    @Column(name = "client_adress_zipcode", length = 10)
    public Long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Long zipcode) {
        this.zipcode = zipcode;
    }
}
