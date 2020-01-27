package modul.feature.user.edit;

import entities.User;
import modul.interfaces.edit.EditDecorator;

import java.util.Scanner;

public class EditFirstName implements EditDecorator<User> {
    private final User user;

    public EditFirstName(User user) {
        this.user = user;
    }

    @Override
    public User changeData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new first name for edit:");
        user.setFirstName(scanner.nextLine());

        return user;
    }
}
