package modul.feature.post;


import entities.Like;
import entities.Post;
import entities.User;
import repositoreis.LikeRepository;
import repositoreis.PostRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class SearchOfPost{
    public Post search(){
        int max = 0;
        Post post1 = PostRepository.getInstance().findAll()
                .stream().max(Comparator.comparingInt(post ->
                        LikeRepository.getInstance().likesOnePost(post).size())).get();

        return post1;

    }

    public Post search(User user){
        Post post1 = user.getPosts().stream().max(Comparator.comparingInt(
                post -> LikeRepository.getInstance().likesOnePost(post).size()
        )).get();

        return post1;
    }

    public Post search(String caption,User user){
        List<Post> posts = user.getPosts().stream().filter(post ->
                post.getCaption().equalsIgnoreCase(caption)).collect(Collectors.toList());
        return posts.get(0);
    }

    public Post search(String caption){
        return PostRepository.getInstance().load(caption);
    }
}
