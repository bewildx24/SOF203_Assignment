package poly.edu.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import poly.edu.model.User;
import poly.edu.repository.UserRepository;
import poly.edu.service.IUserService;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class UserService implements IUserService {

    UserRepository ur = new UserRepository();

    @Override
    public List<User> getAll() {
        return ur.getAll();
    }

    @Override
    public User getOne(String username) {
        return ur.getOne(username);
    }

    @Override
    public Integer addUser(User nguoiDung) {
        return ur.addUser(nguoiDung);
    }

}
