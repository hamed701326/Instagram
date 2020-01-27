package modul.feature.user.edit;

import entities.User;
import modul.interfaces.edit.EditDecorator;

import java.util.Scanner;

public class EditUser {

    public User editManager(String s,User user){
        if (s.equalsIgnoreCase("first name")){
            EditDecorator firstNameE = new EditFirstName(user);
            return  (User) firstNameE.changeData();
        }else if (s.equalsIgnoreCase("last name")){
            EditDecorator lastNameE = new EditLastName(user);
            return (User) lastNameE.changeData();
        }else if (s.equalsIgnoreCase("password")){
            EditDecorator passwordE = new EditPassword(user);
            return (User) passwordE.changeData();
        }else if (s.equalsIgnoreCase("username")){
            EditDecorator usernameE = new EditUsername(user);
            return (User) usernameE.changeData();
        }else {
            return null;
        }
    }

    public void getString(User user){
        Scanner scanner = new Scanner(System.in);
        String  s = null;
        while (scanner.hasNextLine()){
            s = scanner.nextLine();
            editManager(s,user);
        }
    }
}
