package entities;

import configue.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void getFollowers() {
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
//        User user=User.builder()
//                .userName("hamed701326")
//                .email("sadeghi@gmail.com")
//                .lastName("sadeghi")
//                .firstName("hamed")
//                .password("123")
//                .dateCreated(new Date())
//                .build();
//        User user1=user.toBuilder().
//                userName("sadeghi908")
//                .email("hamed70132@yahoo.com")
//                .build();
        User user=session.load(User.class,1);
        User user1=session.load(User.class,2);
        user1.getFollowers().add(user);

//        session.save(user);
//        session.find(User.class,1);
        session.getTransaction().commit();
        session.close();
    }
}