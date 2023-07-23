package ruida.service;

import com.ruida.domain.User;
//定义service接口调用dao层方法
public interface UserService {
    User findById(Integer uid);
}
