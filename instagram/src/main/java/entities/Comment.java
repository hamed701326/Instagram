package entities;

import configue.PersistenceEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Comment extends PersistenceEntity<Integer> {
    private String title;
    @ManyToOne
    private Post post;

}
