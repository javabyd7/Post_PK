package pl.sda.jdbc.controler;

import pl.sda.jdbc.DAO.PostDAO;

public class GetData {
    public static void main(String[] args) {
        PostDAO postDAO = new PostDAO();
        System.out.println(postDAO.showAllPost());
        System.out.println();
        System.out.println(postDAO.showAllComments());
        postDAO.closeSession();
    }
}
