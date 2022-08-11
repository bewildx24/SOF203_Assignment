package poly.edu.model;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class User {

    private String username;
    private String password;
    private int vaitro;

    public User() {
    }

    public User(String username, String password, int vaitro) {
        this.username = username;
        this.password = password;
        this.vaitro = vaitro;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVaitro() {
        return vaitro;
    }

    public void setVaitro(int vaitro) {
        this.vaitro = vaitro;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", vaitro=" + vaitro + '}';
    }

}
