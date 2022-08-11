package poly.edu.repository;

import java.util.List;
import poly.edu.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import poly.edu.utility.JDBCHelper;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class UserRepository {

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try {
            String sql = "select * from users";
            ResultSet rs = JDBCHelper.excuteQuery(sql);

            while (rs.next()) {
                list.add(new User(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    public User getOne(String username) {
        User user = null;
        try {
            String sql = "select * from users where username = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, username);

            while (rs.next()) {
                user = new User(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
            return user;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Integer addUser(User nd) {
        String sql = "insert into users values (?,?,?)";
        Integer row = JDBCHelper.excuteUpdate(sql, nd.getUsername(), nd.getPassword(), nd.getVaitro());
        return row;
    }
}
