package poly.edu.utility;

import java.sql.*;
import poly.edu.repository.DBContext;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class JDBCHelper {

    public static ResultSet excuteQuery(String sql, Object... args) {
        ResultSet rs = null;
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static Integer excuteUpdate(String sql, Object... args) {
        Integer row = 0;
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
