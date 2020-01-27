package modul.feature.post;

import entities.Like;
import entities.Post;

public class Liked {
    public void liked(Post post,String username){
        Like like = new Like();
        like.setPost(post);
        like.setUserName(username);
    }
}
