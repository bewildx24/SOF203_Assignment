package poly.edu.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import poly.edu.model.Student;
import poly.edu.utility.JDBCHelper;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class StudentRepository {

    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        try {
            String sql = "SELECT MASV,HOTEN,EMAIL,SDT,GIOITINH,DIACHI,HINH FROM STUDENT";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                list.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Student getOne(String maSV) {
        Student s = null;
        try {
            String sql = "select * from student where masv = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, maSV);

            while (rs.next()) {
                s = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public Integer add(Student s) {
        try {
            String sql = "insert into student values (?,?,?,?,?,?,?)";
            Integer row = JDBCHelper.excuteUpdate(sql, s.getMaSV(), s.getHoTen(), s.getEmail(), s.getSdt(), s.getGioiTinh(), s.getDiaChi(), s.getHinh());
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Integer delete(String maSV) {
        try {
            String sql = "DELETE FROM GRADE WHERE MASV = ?  DELETE FROM STUDENT WHERE MASV = ?";
            Integer row = JDBCHelper.excuteUpdate(sql, maSV, maSV);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Integer update(Student s, String maSV) {
        try {
            String sql = "update student set hoten = ?,email = ?,sdt = ?,gioitinh = ?,diachi = ?,hinh = ? where masv = ?";
            Integer row = JDBCHelper.excuteUpdate(sql, s.getHoTen(), s.getEmail(), s.getSdt(), s.getGioiTinh(), s.getDiaChi(), s.getHinh(), maSV);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
