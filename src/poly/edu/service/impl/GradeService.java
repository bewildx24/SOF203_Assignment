package poly.edu.service.impl;

import java.util.List;
import poly.edu.model.Grade;
import poly.edu.repository.GradeRepository;
import poly.edu.service.IGradeService;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class GradeService implements IGradeService {

    GradeRepository gr = new GradeRepository();

    @Override
    public List<Grade> getAll() {
        return gr.getAll();
    }

    @Override
    public List<Grade> getTop3() {
        return gr.getTop3();
    }

    @Override
    public Grade getOne(String maSV) {
        return gr.getOne(maSV);
    }

    @Override
    public Integer add(Grade grade) {
        return gr.add(grade);
    }

    @Override
    public Integer delete(int id) {
        return gr.delete(id);
    }

    @Override
    public Integer update(Grade g, int id) {
        return gr.update(g, id);
    }

    @Override
    public List<Grade> search(String maSV) {
        return gr.search(maSV);
    }

}
