package SpringTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import orm.AddressRepository;
import orm.User;
import orm.UserRepository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by ZhangQ on 2018/4/13.
 */
@Transactional(value = "transactionManager",rollbackFor = Exception.class)
public class JpaTest extends BaseSpringTest{

    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void testConfig() throws SQLException {
        System.out.println(dataSource.getConnection());
    }


    @Test
    public void testJpaQuickStart(){
        userRepository.findById(1).ifPresent(System.out::println);
    }

    @Test
    @Rollback(false)
    public void testUserInsert(){
        User user = new User();
        user.setName("Jack");
        user.setPassword(123);
        User user1 = userRepository.save(user);
    }

    @Test
    public void testUserQuery(){
        userRepository.findAll().forEach(System.out::println);
    }

}
