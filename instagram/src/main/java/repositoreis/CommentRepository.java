package repositoreis;

import configue.hibernate.CrudRepository;
import configue.hibernate.HibernateUtil;
import entities.Comment;
import org.hibernate.Session;

public class CommentRepository extends CrudRepository<Comment,Integer> {

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }

    @Override
    protected Session getSession() {
        return HibernateUtil.getSession();
    }

    private static CommentRepository commentRepository;

    private CommentRepository() {
    }

    public static CommentRepository getInstance(){
        if (commentRepository == null)
            return new CommentRepository();
        else
            return commentRepository;
    }
}
