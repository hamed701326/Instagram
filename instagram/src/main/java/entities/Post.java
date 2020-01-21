package entities;

import configue.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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


}
