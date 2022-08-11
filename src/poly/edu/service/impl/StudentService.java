package poly.edu.service.impl;

import java.util.List;
import poly.edu.model.Student;
import poly.edu.repository.StudentRepository;
import poly.edu.service.IStudentService;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class StudentService implements IStudentService {

    StudentRepository sr = new StudentRepository();

    @Override
    public List<Student> getAll() {
        return sr.getAll();
    }

    @Override
    public Student getOne(String maSV) {
        return sr.getOne(maSV);
    }

    @Override
    public Integer add(Student s) {
        return sr.add(s);
    }

    @Override
    public Integer delete(String maSV) {
        return sr.delete(maSV);
    }

    @Override
    public Integer update(Student s, String maSV) {
        return sr.update(s, maSV);
    }

}
