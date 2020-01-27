import entities.Post;
import entities.User;
import modul.feature.post.*;
import modul.feature.user.*;
import modul.feature.user.edit.EditUser;

import java.util.Scanner;

public class InstagramApp {
    Scanner scanner = new Scanner(System.in);

    private static User user;

    public static void main(String[] args) {
        InstagramApp instagram = new InstagramApp();

        user = instagram.step1();
        instagram.step2(user);
    }

    public User step1(){
        System.out.println("<<Menu>>");
        System.out.println("*login");
        System.out.println("*sign up");
        System.out.println("*exit");

        String step1 = scanner.nextLine();
        if (step1.equalsIgnoreCase("login")){
            Login login = new Login();
            login.setData();
            User user = login.login();
            return user;
        }else if (step1.equalsIgnoreCase("sign up")){
            AddUser addUser = new AddUser();
            addUser.add(addUser.getData());
            step1();
        }else if (step1.equalsIgnoreCase("exit")){
            return null;
        }else {
            System.out.println("commend not found:"+step1);
            step1();
        }
        return null;
    }

    public void step2(User user){
        System.out.println("<<Menu>>");
        System.out.println("*home");
        System.out.println("*post");
        System.out.println("*my account");
        System.out.println("*back");

        String step2 = scanner.nextLine();

        if (step2.equalsIgnoreCase("home")){

        }else if (step2.equalsIgnoreCase("post")){
            postInStep2();
        }else if (step2.equalsIgnoreCase("my account")){
            myAccount();
        }else if (step2.equalsIgnoreCase("back")){
            step1();
            return;
        }else
            step2(user);
    }

    public void postInStep2(){
        System.out.println("<<Menu>>");
        System.out.println("*show my post");
        System.out.println("*add post");
        System.out.println("*delete post");
        System.out.println("*edit post");
        System.out.println("*search of post(max like)");
        System.out.println("*search of post(caption)");
        System.out.println("*back");

        String post = scanner.nextLine();
        if (post.equalsIgnoreCase("show my post")){
            ViewPostsByUser postsByUser = new ViewPostsByUser();

            System.out.println("<<Menu>>");
            System.out.println("*show one post");
            System.out.println("*back");
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("show one post")){
                ShowPost showPost = new ShowPost();
                showPost.show(showPost.loadPost(showPost.getData()));
                postInStep2();
            }else {
                postInStep2();
            }

            postsByUser.viewPostByUser(user);

            postInStep2();
        }else if (post.equalsIgnoreCase("add post")){
            AddPost addPost = new AddPost();

            addPost.add(addPost.setUserToPost(user,addPost.getData()));

            postInStep2();
        }else if (post.equalsIgnoreCase("delete post")){
            DeletePost deletePost = new DeletePost();

            deletePost.delete(deletePost.getData());

            postInStep2();
        }else if (post.equalsIgnoreCase("edit post")){
            EditPost editPost = new EditPost();

            editPost.edit(editPost.getData(editPost.load()));

            postInStep2();
        }else if (post.equalsIgnoreCase("search of post")){
            SearchOfPost searchOfPost = new SearchOfPost();
            ShowPost showPost = new ShowPost();

            Post post1 = searchIn();

            System.out.println("<<Menu>>");
            System.out.println("*comment");
            System.out.println("*like");

            String s = scanner.nextLine();

            if (s.equalsIgnoreCase("comment")){
                CommentForPost commentForPost = new CommentForPost();
                commentForPost.comment(
                        commentForPost.getDataForComment(post1)
                );
            }else if (s.equalsIgnoreCase("like")){
                Liked liked = new Liked();
                liked.liked(post1,user.getUserName());
            }
            postInStep2();
        }else if (post.equalsIgnoreCase("exit")){
            step2(user);
        }else {
            System.out.println("command not found:"+post);
            postInStep2();
        }
    }

    public Post searchIn(){
        SearchOfPost searchOfPost = new SearchOfPost();

        System.out.println("<<Menu search>>");
        System.out.println("*search by caption");
        System.out.println("*search by number like");
        System.out.println("*back");

        String search = scanner.nextLine();

        if (search.equalsIgnoreCase("search by caption")){
            String caption = scanner.nextLine();
            Post post = searchOfPost.search(caption);
            return post;
        }else if (search.equalsIgnoreCase("search by number like")){
            return searchOfPost.search();
        }else {
            postInStep2();
            return null;
        }
    }

    public void myAccount(){
        System.out.println("<<Menu>>");
        System.out.println("*show my account");
        System.out.println("*delete account");
        System.out.println("*edit account");
        System.out.println("*search of account");
        System.out.println("*back");

        String account = scanner.nextLine();

        if (account.equalsIgnoreCase("show my account")){
            ShowUser showUser = new ShowUser();
            showUser.show(user);
        }else if (account.equalsIgnoreCase("delete account")){
            DeleteUser deleteUser = new DeleteUser();
            deleteUser.delete(user);
        }else if (account.equalsIgnoreCase("edit account")){
            EditUser editUser = new EditUser();
            editUser.getString(user);
        }else if (account.equalsIgnoreCase("search of account")){
            SearchUser searchUser = new SearchUser();
            User user1 = searchUser.search(searchUser.getData());

            ShowUser showUser1 = new ShowUser();
            showUser1.show(user1);

        }else if (account.equalsIgnoreCase("back")){
            step2(user);
        }else
            myAccount();
    }


}
