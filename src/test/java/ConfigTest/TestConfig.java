package ConfigTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import orm.User;
import orm.UserRepository;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by ZhangQ on 2018/4/15.
 */
public class TestConfig {
    private static ApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("classpath:spring.xml");
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = (DataSource)context.getBean("dataSource");
        System.out.println(dataSource.getConnection());
        System.out.println(dataSource);
    }

    @Test
    public void testJPA01(){
    }
}
