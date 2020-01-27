package modul.feature.user.edit;

import entities.User;
import modul.interfaces.edit.EditDecorator;

import java.util.Scanner;

public class EditUsername implements EditDecorator<User> {
    private final User user;

    public EditUsername(User user) {
        this.user = user;
    }

    @Override
    public User changeData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new username for edit:");
        user.setUserName(scanner.nextLine());
        return user;
    }
}
