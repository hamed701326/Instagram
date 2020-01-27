package modul.feature.post;

import entities.Post;
import modul.interfaces.Delete;
import repositoreis.PostRepository;

import java.util.Scanner;

public class DeletePost implements Delete<Post> {
    @Override
    public void delete(Post post) {
        PostRepository.getInstance().remove(post);
    }

    @Override
    public Post getData() {
        Scanner scanner = new Scanner(System.in);
        Post post = new Post();

        System.out.println("delete/post");
        System.out.println("Enter Caption post for delete:");
        String s = scanner.nextLine();
        return PostRepository.getInstance().load(s);
    }
}
