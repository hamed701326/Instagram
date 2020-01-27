package repositoreis;

import configue.hibernate.CrudRepository;
import configue.hibernate.HibernateUtil;
import entities.User;
import org.hibernate.Session;

public class UserRepository extends CrudRepository<User,Integer> {
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected Session getSession() {
        return HibernateUtil.getSession();
    }

    private UserRepository() {
    }

    private static UserRepository userRepository;

    public static UserRepository getInstance(){
        if (userRepository == null)
            return new UserRepository();
        else
            return userRepository;
    }
}
