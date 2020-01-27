package modul.feature.user;

import entities.User;
import modul.interfaces.Delete;
import repositoreis.UserRepository;

import java.util.Scanner;

public class DeleteUser implements Delete<User> {

    @Override
    public void delete(User user) {
        UserRepository.getInstance().remove(user);
    }

    @Override
    public User getData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("delete/user");
        System.out.println("Enter username or email for delete account:");

        String s = scanner.nextLine();

        return UserRepository.getInstance().load(s);
    }
}
