package modul.feature.user;

import entities.User;

public class ViewPostsByUser {
    public void viewPostByUser(User user){
        user.getPosts().stream()
                .forEach(post -> {
                    System.out.print(post.getCaption()+"-->");
                    System.out.println(post.getImagePath());
                });
    }
}
