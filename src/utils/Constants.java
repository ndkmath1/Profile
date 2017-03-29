package utils;

/**
 * Created by Khanh Nguyen on 27/03/2017.
 */
public class Constants {
    public static final String URL = "jdbc:mysql://localhost:3306/profile";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    public static final String CHECK_LOGIN = "SELECT * FROM account WHERE username=? AND password=?";
    public static final String GET_USER = "SELECT * FROM user_info WHERE account_id=?";
    public static final String UPDATE_INFO = "UPDATE user_info SET fullname=?, birthday=?, address=?, hobie=?,phone=?, description=? WHERE account_id=?";
}
