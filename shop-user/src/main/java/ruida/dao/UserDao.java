package ruida.dao;

import com.ruida.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//表明这个类具有对对象CRUD（增删改查）的功能
public interface UserDao extends JpaRepository<User,Integer> {
}
