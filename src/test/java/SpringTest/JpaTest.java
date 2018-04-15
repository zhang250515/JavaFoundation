package SpringTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import orm.AddressRepository;
import orm.User;
import orm.UserRepository;

/**
 * Created by ZhangQ on 2018/4/13.
 */
public class JpaTest extends BaseSpringTest{

    @Autowired
    UserRepository repository;

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void testJpa01(){
        System.out.println(repository.getById(1));
        System.out.println(addressRepository.getById(1));
    }

    @Test
    public void testJpa02(){
        System.out.println(repository.testId(1));
        System.out.println(repository.testJpqlId(1));
    }

    @Test
    public void testJpa03(){
        System.out.println(repository.testJpqlId(1));
    }
}
