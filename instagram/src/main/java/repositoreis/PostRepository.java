package repositoreis;

import configue.hibernate.CrudRepository;
import configue.hibernate.HibernateUtil;
import entities.Post;
import org.hibernate.Session;

public class PostRepository extends CrudRepository<Post,Integer> {
    @Override
    protected Class<Post> getEntityClass() {
        return Post.class;
    }

    @Override
    protected Session getSession() {
        return HibernateUtil.getSession();
    }

    private PostRepository() {
    }

    private static PostRepository postRepository;

    public static synchronized PostRepository getInstance(){
        if (postRepository == null)
            return new PostRepository();
        else
            return postRepository;
    }
}
