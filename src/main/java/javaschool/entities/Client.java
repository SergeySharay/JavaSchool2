package javaschool.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "clients", schema = "client")
@NamedQueries({
        @NamedQuery(name = "Client.getClients", query = "SELECT C from Client C"),
        @NamedQuery(name = "Client.getClient", query = "SELECT C from Client C where C.email =:email"),
        @NamedQuery(name = "Client.getOrders", query = "SELECT O from Orders O where client=:client")
})
public class Client implements Serializable {

    private Long clientId;
    private String email;
    private String name;
    private String surname;
    private String password;
    private Integer permission;
    private Date birthday;
    private Set<Orders> orders;
    private Set<ClientAddress> clientAddressSet;

    public Client() {
    }

    public Client(String email, String name, String surname, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.permission = 2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 10, unique = true, nullable = false)
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @OneToMany(targetEntity = ClientAddress.class, mappedBy = "client", fetch = FetchType.EAGER)
    public Set<ClientAddress> getClientAddressSet() {
        return clientAddressSet;
    }

    public void setClientAddressSet(Set<ClientAddress> clientAddressSet) {
        this.clientAddressSet = clientAddressSet;
    }

    @OneToMany(targetEntity = Orders.class, mappedBy = "client", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    @Column(name = "client_email", length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "client_name", length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "client_surname", length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "client_password", length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "client_permission", length = 50)
    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    @Column(name = "client_birhtday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}

