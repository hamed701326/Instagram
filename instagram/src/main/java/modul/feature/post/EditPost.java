package modul.feature.post;

import entities.Post;
import modul.interfaces.edit.Edit;
import repositoreis.PostRepository;

import java.util.Date;
import java.util.Scanner;

public class EditPost implements Edit<Post> {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void edit(Post post) {
        post.setDateUpdated(new Date());
        PostRepository.getInstance().update(post);
    }

    public Post getData(Post post){

        System.out.println("edit/post");
        System.out.println("Enter new caption for edit post:");
        String s = scanner.nextLine();

        post.setCaption(s);

        return post;
    }

    public Post load(){
        System.out.println("Enter caption for edit:");
        String s = scanner.nextLine();

        return PostRepository.getInstance().load(s);
    }
}
