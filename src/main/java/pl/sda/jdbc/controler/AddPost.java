package pl.sda.jdbc.controler;

import pl.sda.jdbc.DAO.PostDAO;
import pl.sda.jdbc.entity.Post;
import pl.sda.jdbc.entity.PostDetails;

import java.sql.Date;

public class AddPost {
    public static void main(String[] args) {
        PostDAO postDAO = new PostDAO();
        PostDetails postDetails1 = new PostDetails("XXX", Date.valueOf("2018-6-22"), 1);
        Post post1 = new Post("First post", postDetails1);
        PostDetails postDetails2 = new PostDetails("YYY", Date.valueOf("2018-6-22"), 1);
        Post post2 = new Post("Second post", postDetails2);
        PostDetails postDetails3 = new PostDetails("ZZZ", Date.valueOf("2018-6-22"), 1);
        Post post3 = new Post("Third post", postDetails3);
        postDAO.postService(postDetails1, post1);
        postDAO.postService(postDetails2, post2);
        postDAO.postService(postDetails3, post3);
        postDAO.closeSession();
    }
}
