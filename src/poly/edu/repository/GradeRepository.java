package poly.edu.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import poly.edu.model.Grade;
import poly.edu.model.Student;
import poly.edu.utility.JDBCHelper;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class GradeRepository {

    public List<Grade> getAll() {
        try {
            List<Grade> list = new ArrayList<>();
            String sql = "SELECT * FROM GRADE A JOIN STUDENT B ON A.MASV = B.MASV";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                Student s = new Student(rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getByte(10), rs.getString(11), rs.getString(12));
                list.add(new Grade(rs.getInt(1), rs.getString(2), s, rs.getFloat(3), rs.getFloat(4), rs.getFloat(5)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Grade> getTop3() {
        try {
            List<Grade> list = new ArrayList<>();
            String sql = "SELECT TOP 3 * FROM GRADE A JOIN STUDENT B ON A.MASV = B.MASV ORDER BY (TIENGANH+TINHOC+GDTC)/3 DESC";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                Student s = new Student(rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getByte(10), rs.getString(11), rs.getString(12));
                list.add(new Grade(rs.getInt(1), rs.getString(2), s, rs.getFloat(3), rs.getFloat(4), rs.getFloat(5)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Grade getOne(String maSV) {
        Grade g = null;
        try {
            List<Grade> list = new ArrayList<>();
            String sql = "SELECT * FROM STUDENT A LEFT JOIN GRADE B ON A.MASV = B.MASV WHERE A.MASV = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, maSV);
            while (rs.next()) {
                Student s = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getByte(5), rs.getString(6), rs.getString(7));
                g = new Grade(rs.getInt(8), rs.getString(9), s, rs.getFloat(10), rs.getFloat(11), rs.getFloat(12));
            }
            return g;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer add(Grade g) {
        try {
            String sql = "INSERT INTO GRADE VALUES (?,?,?,?)";
            Integer row = JDBCHelper.excuteUpdate(sql, g.getMaSv(), g.getTiengAnh(), g.getTinHoc(), g.getGdtc());
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Integer delete(int id) {
        try {
            String sql = "DELETE FROM GRADE WHERE ID = ?";
            Integer row = JDBCHelper.excuteUpdate(sql, id);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Integer update(Grade g, int id) {
        try {
            String sql = "UPDATE GRADE SET TIENGANH = ?, TINHOC = ?, GDTC = ? WHERE ID = ?";
            Integer row = JDBCHelper.excuteUpdate(sql, g.getTiengAnh(), g.getTinHoc(), g.getGdtc(), g.getId());
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Grade> search(String maSV) {
        List<Grade> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM GRADE A JOIN STUDENT B ON A.MASV = B.MASV WHERE A.MASV LIKE '%" + maSV + "%'";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                Student s = new Student(rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getByte(10), rs.getString(11), rs.getString(12));
                list.add(new Grade(rs.getInt(1), rs.getString(2), s, rs.getFloat(3), rs.getFloat(4), rs.getFloat(5)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
