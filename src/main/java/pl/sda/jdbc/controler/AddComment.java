package pl.sda.jdbc.controler;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.jdbc.config.HibernateUtils;
import pl.sda.jdbc.entity.Post;
import pl.sda.jdbc.entity.PostComment;

public class AddComment {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        int postId = 5;
        Post getPost = session.get(Post.class, postId);
        if(getPost == null){
            throw new RuntimeException("Post no exist!!!");
        } else {
            PostComment postComment = new PostComment("loremloremloremloremloremloremlorem", 1, getPost);
            session.save(postComment);
            transaction.commit();
        }
        HibernateUtils.closeSession();
    }


}
