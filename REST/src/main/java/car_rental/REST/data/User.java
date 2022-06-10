package car_rental.REST.data;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;


    @OneToOne
    @JoinColumn(name = "client_id")
    @RestResource(path = "userClient")
    private Client client;

    @OneToMany(mappedBy = "user")
    private List<Rental> rentals;

    public User(int id, String username, String password, Client client) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.client = client;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
