package pl.sda.jdbc.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.jdbc.config.HibernateUtils;
import pl.sda.jdbc.entity.Post;
import pl.sda.jdbc.entity.PostDetails;

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
}
