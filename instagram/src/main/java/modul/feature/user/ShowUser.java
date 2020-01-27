package modul.feature.user;

import entities.Post;
import entities.User;
import modul.interfaces.Show;
import repositoreis.UserRepository;

import java.util.Scanner;

public class ShowUser implements Show<User> {
    @Override
    public <Attribute> User show(Attribute attribute) {
        User user = UserRepository.getInstance().load(attribute);

        System.out.println("first name:"+user.getFirstName());
        System.out.println("last name:"+user.getLastName());
        System.out.println("username:"+user.getUserName());
        System.out.println("number followers"+user.getFollowers().size());
        System.out.println("number following"+user.getFollowings().size());

        return user;

    }

    public String getData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("show/oneUser");
        System.out.println("select one of attributes from user for edit:");
        System.out.println("(username|email|firstName|lastName)");

        String s = scanner.nextLine();

        return s;
    }
}
