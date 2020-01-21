package entities;

import configue.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends PersistenceEntity<Integer> {
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String lastIP;
    private Date dateCreated;
    private Date dateUpdated;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="User_id")
    private User follower;

    @OneToMany(mappedBy = "User")
    private Set<User> following=new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastIP='" + lastIP + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}