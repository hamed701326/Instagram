package modul.feature.post;

import entities.Post;
import entities.User;
import modul.interfaces.Add;
import repositoreis.PostRepository;

import java.util.Date;
import java.util.Scanner;

public class AddPost implements Add<Post>{

    @Override
    public boolean add(Post post) {
        post.setDateCreated(new Date());
        PostRepository.getInstance().save(post);
        return false;
    }

    @Override
    public Post getData() {
        Scanner scanner = new Scanner(System.in);
        Post post = new Post();

        System.out.println("add/post");
        post.setCaption(scanner.nextLine());
        return post;
    }

    public Post setUserToPost(User user,Post post){
        post.setUser(user);
        return post;
    }
}
