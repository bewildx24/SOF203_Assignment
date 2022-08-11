package poly.edu.service;

import java.util.List;
import poly.edu.model.Student;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IStudentService {

    List<Student> getAll();

    Student getOne(String maSV);

    Integer add(Student s);

    Integer delete(String maSV);

    Integer update(Student s, String maSV);
}
