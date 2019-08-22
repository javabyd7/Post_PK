package pl.sda.jdbc.controler;

import pl.sda.jdbc.DAO.PostDAO;

public class DeleteData {
    public static void main(String[] args) {
    PostDAO postDAO = new PostDAO();
        postDAO.postDelete(2);
    }
}
