package modul.feature.post;

import entities.Post;
import modul.interfaces.edit.Edit;
import repositoreis.PostRepository;

import java.util.Date;
import java.util.Scanner;

public class EditPost implements Edit<Post> {
    @Override
    public void edit(Post post) {
        post.setDateUpdated(new Date());
        PostRepository.getInstance().update(post);
    }

    Post getData(Post post){
        Scanner scanner = new Scanner(System.in);

        System.out.println("edit/post");
        System.out.println("Enter new caption for edit post:");
        String s = scanner.nextLine();

        post.setCaption(s);

        return post;
    }
}
