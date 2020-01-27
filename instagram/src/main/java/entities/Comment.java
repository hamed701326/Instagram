package entities;

import configue.PersistenceEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
public class Comment extends PersistenceEntity<Integer> {
    private String title;
    private String content;
    private String username;
    private Date CreateDateComment;
    private Date UpdateDateComment;
    @ManyToOne
    private Post post;

}
