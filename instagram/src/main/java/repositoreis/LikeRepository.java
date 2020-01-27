package repositoreis;

import configue.hibernate.CrudRepository;
import configue.hibernate.HibernateUtil;
import entities.Like;
import entities.Post;
import org.hibernate.Session;

import java.util.List;

public class LikeRepository extends CrudRepository<Like,Integer> {
    private static LikeRepository likeRepository;

    public LikeRepository() {
    }

    public static synchronized LikeRepository getInstance(){
        if (likeRepository == null)
            return new LikeRepository();
        else
            return likeRepository;
    }

    @Override
    protected Class<Like> getEntityClass() {
        return Like.class;
    }

    @Override
    protected Session getSession() {
        return HibernateUtil.getSession();
    }

    public List<Like> likesOnePost(Post post){
        getSession().beginTransaction();
        List<Like> likes = getSession()
                .createQuery(" from "+getEntityClass()+" where "+post).list();

        getSession().getTransaction().commit();

        return likes;
    }
}
