package modul.feature.user;

import entities.User;
import modul.interfaces.Add;

public class AddUser implements Add<User> {
    @Override
    public boolean add(User user) {
        return false;
    }

}
