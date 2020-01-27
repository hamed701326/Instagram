package modul.feature.user;

import entities.User;
import modul.interfaces.Add;
import repositoreis.UserRepository;


import java.util.Date;
import java.util.Scanner;

public class AddUser implements Add<User> {
    @Override
    public boolean add(User user) {
        user.setDateCreated(new Date());
        int id = UserRepository.getInstance().save(user);
        return id == -1?false:true;
    }

    public User getData(){
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        System.out.println("add/user");
        System.out.println("Enter your username:");
        user.setUserName(scanner.nextLine());

        System.out.println("Enter your password:");
        user.setPassword(scanner.nextLine());

        System.out.println("Enter your email:");
        user.setEmail(scanner.nextLine());

        System.out.println("Enter your first name:");
        user.setFirstName(scanner.nextLine());

        System.out.println("Enter your last name:");
        user.setLastName(scanner.nextLine());

        return user;

    }

}
