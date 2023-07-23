package ruida.controller;

import com.ruida.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ruida.service.UserService;

import javax.persistence.criteria.CriteriaBuilder;
@EntityScan("com.ruida.domain")//用来扫描和发现指定包及其子包中的Entity定义
@RestController//就是注册一个控制器，并且将响应的数据以指定的格式写入到Response的body中。
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user/{uid}")
    public User user(@PathVariable("uid") Integer uid){
        User user= userService.findById(uid);
        return user;
    }
}
