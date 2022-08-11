package poly.edu.service;

import java.util.List;
import poly.edu.model.User;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IUserService {

    public List<User> getAll();

    public User getOne(String username);

    public Integer addUser(User nguoiDung);
}
