package modul.feature.post;

import entities.Comment;
import entities.Post;
import repositoreis.CommentRepository;

import java.util.Date;
import java.util.Scanner;

public class CommentForPost {

    public void comment(Comment comment){
        CommentRepository.getInstance().save(comment);
    }

    public Comment getDataForComment(Post post){
        Scanner scanner = new Scanner(System.in);
        Comment comment = new Comment();

        System.out.println("comment/"+post.getCaption()+"/"+post.getUser());
        System.out.println("Enter title comment:");
        comment.setTitle(scanner.nextLine());

        System.out.println("Enter content comment:");
        comment.setContent(scanner.nextLine());

        System.out.println("Enter username of commenter:");
        comment.setUsername(scanner.nextLine());

        comment.setPost(post);
        comment.setCreateDateComment(new Date());

        return comment;

    }
}
