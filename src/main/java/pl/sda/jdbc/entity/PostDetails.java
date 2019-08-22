package pl.sda.jdbc.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "post_details")
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date date;

    @Column(name = "version")
    private int version;

    @OneToOne(mappedBy = "postDetails")
    private Post post;

    public PostDetails() {
    }

    public PostDetails(String createdBy, Date date, int version) {
        this.createdBy = createdBy;
        this.date = date;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "PostDetails{" +
                "id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", date=" + date +
                ", version=" + version +
                '}';
    }
}
