package pl.sda.jdbc.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.jdbc.config.HibernateUtils;
import pl.sda.jdbc.entity.Post;
import pl.sda.jdbc.entity.PostComment;
import pl.sda.jdbc.entity.PostDetails;

import java.sql.Date;
import java.util.List;

public class PostDAO {
    public Post postService (PostDetails postDetails, Post post){
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(postDetails);
        session.save(post);
        transaction.commit();
        return post;
    }

    public void closeSession(){
        HibernateUtils.closeSession();
        System.out.println("Session close");
    }

    public List<Post> showAllPost(){
        Session session = HibernateUtils.getSession();
        List<Post> posts = session.createQuery("select a from Post a", Post.class).getResultList();
        return posts;
    }

    public List<PostComment> showAllComments(){
        Session session = HibernateUtils.getSession();
        List<PostComment> postComments = session.createQuery("select a from PostComment a", PostComment.class).getResultList();
        return postComments;
    }

    public PostComment commentUpdate (String newReview, int postCommentId){
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        PostComment postComment = session.get(PostComment.class, postCommentId);
        postComment.setReview(newReview);
        postComment.setVersion(postComment.getVersion()+1);
        session.update(postComment);
        transaction.commit();
        HibernateUtils.closeSession();
        return postComment;
    }

    public Post postUpdate (String newTitle, int postId){
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Post post = session.get(Post.class, postId);
        post.setTitle(newTitle);
        session.update(post);
        transaction.commit();
        HibernateUtils.closeSession();
        return post;
    }

    public PostDetails postDetailsUpdate (String createBy, String newData, int postDetailsId){
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        PostDetails postDetails = session.get(PostDetails.class, postDetailsId);
        postDetails.setCreatedBy(createBy);
        postDetails.setDate(Date.valueOf(newData));
        session.update(postDetails);
        transaction.commit();
        HibernateUtils.closeSession();
        return postDetails;
    }


}
