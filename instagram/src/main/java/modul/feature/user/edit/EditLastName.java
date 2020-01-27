package modul.feature.user.edit;

import entities.User;
import modul.interfaces.edit.EditDecorator;

import java.util.Scanner;
import java.util.SortedSet;

public class EditLastName implements EditDecorator<User> {
    private final User user;

    public EditLastName(User user) {
        this.user = user;
    }

    @Override
    public User changeData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new last name for edit:");
        user.setLastName(scanner.nextLine());

        return user;
    }
}
