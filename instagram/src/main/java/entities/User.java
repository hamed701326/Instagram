package entities;

import configue.PersistenceEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "user")
@EqualsAndHashCode(exclude = {"post",})
public class User extends PersistenceEntity<Integer> {
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String lastIP;
    private Date dateCreated;
    private Date dateUpdated;
//    @ManyToOne(cascade =CascadeType.ALL)
//    @JoinTable(name = "following_follower",
//            joinColumns = {@JoinColumn(name = "following_id")},
//            inverseJoinColumns = {@JoinColumn(name = "follower_id")})
//    private User follower;
//    @OneToMany(mappedBy = "follower")
//    private Set<User> followings=new HashSet<>();


    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "following_follower",
            joinColumns = {@JoinColumn(name = "following_id")},
            inverseJoinColumns = {@JoinColumn(name = "follower_id")})
    private Set<User> followers = new HashSet<>();

    @ManyToMany(mappedBy = "followers", fetch = FetchType.EAGER)
    private Set<User> followings = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Post> posts=new HashSet<>();


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