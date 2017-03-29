package dao;

import utils.DBUtils;
import utils.Constants;
import model.Account;
import model.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Khanh Nguyen on 27/03/2017.
 */
public class AccountDao {
    public Connection con = null;
    public ResultSet resultSet = null;
    public PreparedStatement preparedStatement;
    public Account login(Account account){
        String query = Constants.CHECK_LOGIN;
        try {
            con = DBUtils.getConnection();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                account.setAccountId(resultSet.getInt("account_id"));
                account.setRole(resultSet.getInt("role"));
                return account;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public UserInfo getUserInfo(Account account){
        UserInfo userInfo = null;
        String query = Constants.GET_USER;
        try {
            con = DBUtils.getConnection();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, account.getAccountId());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                userInfo = new UserInfo();
                userInfo.setFullName(resultSet.getString("fullname"));
                userInfo.setBirthday(resultSet.getString("birthday"));
                userInfo.setAddress(resultSet.getString("address"));
                userInfo.setHobie(resultSet.getString("hobie"));
                userInfo.setPhone(resultSet.getString("phone"));
                userInfo.setDescription(resultSet.getString("description"));
                userInfo.setAccount(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userInfo;
    }

    public boolean update(UserInfo userInfo){
        String query = Constants.UPDATE_INFO;
        try {
            con = DBUtils.getConnection();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, userInfo.getFullName());
            preparedStatement.setString(2, userInfo.getBirthday());
            preparedStatement.setString(3, userInfo.getAddress());
            preparedStatement.setString(4, userInfo.getHobie());
            preparedStatement.setString(5, userInfo.getPhone());
            preparedStatement.setString(6, userInfo.getDescription());
            preparedStatement.setInt(7, userInfo.getAccount().getAccountId());
            if(preparedStatement.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
