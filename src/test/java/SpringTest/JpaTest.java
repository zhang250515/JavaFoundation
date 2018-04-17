package SpringTest;

import Utils.PermToDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import orm.*;

import java.util.*;

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

    @Autowired
    PermRepository permRepository;

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
    public void permTree(){
        Iterable<Perm> perms = permRepository.findAll();
        List<PermDto> dtos1 = new LinkedList<>();
        perms.forEach(perm -> {
            dtos1.add(PermToDto.converse(perm));
        });
        List<PermDto> dtos = getTree(dtos1,0);
        if (Objects.nonNull(dtos))
            dtos.forEach(System.out::println);
    }

    private List<PermDto> getTree(List<PermDto> dtos,int id){
        if (dtos.size() == 0)
            return null;
        List<PermDto> dtoList = new ArrayList<>();
        List<PermDto> dtoListC = new ArrayList<>(dtos);
        for (PermDto dto : dtos){
            if (dto.getParentId() == id) {
                dtoListC.remove(dto);
                dto.setChildren(getTree(dtoListC,dto.getId()));
                dtoList.add(dto);
            }
        }
        if (dtoList.size() == 0)
            return null;
        return dtoList;
    }

    @Test
    public void testUserQuery(){
        userRepository.findAll().forEach(System.out::println);
    }

}
