package modul.feature.user;

import entities.User;
import modul.interfaces.Search;
import repositoreis.UserRepository;

import java.util.Scanner;

public class SearchUser implements Search<User> {
    @Override
    public <String> User search(String s) {
        User user = UserRepository.getInstance().load(s);
        return user;
    }

    public String getData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("<<search/user>>");
        System.out.println("Enter username:");

        String s = scanner.nextLine();

        return s;
    }
}
