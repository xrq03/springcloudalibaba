package ruida.service.impl;

import com.ruida.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruida.dao.UserDao;
import ruida.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findById(Integer uid) {
        return userDao.findById(uid).get();
    }
}
