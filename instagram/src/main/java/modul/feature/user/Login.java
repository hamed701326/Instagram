package modul.feature.user;

import entities.User;
import repositoreis.UserRepository;

import java.util.Scanner;

public class Login {
    private String username;
    private String password;

    public void setData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        this.username = scanner.nextLine();
        System.out.println("Enter password:");
        this.password = scanner.nextLine();
    }
    public User login(){
        User user = UserRepository.getInstance().load(username);

        if (user.getPassword().equals(password)){
            System.out.println("login successful!!");
            return user;
        }else{
            System.out.println("login fail");
            return null;
        }
    }
}
