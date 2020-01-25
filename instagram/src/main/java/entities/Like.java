package entities;

import configue.PersistenceEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "like")
public class Like extends PersistenceEntity<Integer> {
    private String userName;
    @ManyToOne
    private Post post;
}
