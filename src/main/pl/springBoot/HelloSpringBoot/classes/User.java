package pl.springBoot.HelloSpringBoot.classes;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Repository
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Email
    @Column
    @NotEmpty
    private String email;
    @Column
    @NotEmpty
    private String username;
    @Column
    @NotEmpty
    private String password;


    public User(){}

    public User(String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User: " + "id=" + id + ", name=" + username +
                ", password=" + password + ", email=" + email;
    }
}
