package poly.edu.model;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class Grade {

    private int id;
    private String maSv;
    private Student student;
    private float tiengAnh;
    private float tinHoc;
    private float gdtc;

    public Grade() {
    }

    public Grade(int id, String maSv, Student student, float tiengAnh, float tinHoc, float gdtc) {
        this.id = id;
        this.maSv = maSv;
        this.student = student;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public float getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(float tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public float getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(float tinHoc) {
        this.tinHoc = tinHoc;
    }

    public float getGdtc() {
        return gdtc;
    }

    public void setGdtc(float gdtc) {
        this.gdtc = gdtc;
    }

    @Override
    public String toString() {
        return "Grade{" + "id=" + id + ", maSv=" + maSv + ", student=" + student + ", tiengAnh=" + tiengAnh + ", tinHoc=" + tinHoc + ", gdtc=" + gdtc + '}';
    }

}
