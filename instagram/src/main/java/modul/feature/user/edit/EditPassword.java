package modul.feature.user.edit;

import entities.User;
import modul.interfaces.edit.EditDecorator;

import java.util.Scanner;

public class EditPassword implements EditDecorator<User> {
    private final User user;

    public EditPassword(User user) {
        this.user = user;
    }

    @Override
    public User changeData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new password for edit:");
        user.setPassword(scanner.nextLine());
        return user;
    }
}
