package poly.edu.service;

import java.util.List;
import poly.edu.model.Grade;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IGradeService {

    List<Grade> getAll();

    List<Grade> getTop3();

    Grade getOne(String maSV);

    Integer add(Grade grade);

    Integer delete(int id);

    Integer update(Grade g, int id);

    List<Grade> search(String maSV);
}
