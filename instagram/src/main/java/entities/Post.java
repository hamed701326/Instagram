package entities;

import configue.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
public class Post extends PersistenceEntity<Integer> {
    private String caption;
    private Float latitude;
    private Float longitude;
    private String imagePath;
    private int imageSize;
    private Date dateCreated;
    private Date dateUpdated;
    @ManyToOne()
    private User user;
    @OneToMany()
    private Set<Comment> comments=new HashSet<>();
    @OneToMany(mappedBy = "post")
    private Set<Like> likes;
}
