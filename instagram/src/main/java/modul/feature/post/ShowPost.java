package modul.feature.post;

import entities.Post;
import modul.interfaces.Show;
import repositoreis.LikeRepository;
import repositoreis.PostRepository;

import java.util.Scanner;

public class ShowPost implements Show<Post> {

    public <String> Post loadPost(String attribute) {
        Post post = PostRepository.getInstance().load(attribute);
        return post;
    }

    public String getData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("show/onePost");
        System.out.println("Enter caption for show:");
        String s = scanner.nextLine();

        return s;
    }

    @Override
    public void show(Post post) {

        System.out.println("caption:"+post.getCaption());
        System.out.println("url:"+post.getImagePath());
        System.out.println("like number:"+
                LikeRepository.getInstance().likesOnePost(post).size());
        System.out.println("latitude:"+post.getLatitude());
        System.out.println("longitude:"+post.getLongitude());
        System.out.println("size:"+post.getImageSize());
        System.out.println("create date:"+post.getDateCreated());
    }
}
