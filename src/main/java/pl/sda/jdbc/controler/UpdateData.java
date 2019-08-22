package pl.sda.jdbc.controler;

import pl.sda.jdbc.DAO.PostDAO;

public class UpdateData {
    public static void main(String[] args) {
PostDAO postDAO = new PostDAO();
//postDAO.commentUpdate("new lorem ipsum again", 2);
postDAO.postUpdate("next edit", 2);

    }

}
