package SpringTest;

import Utils.PermToDto;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import orm.*;

import java.util.*;

import javax.json.Json;
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
        User u = userRepository.testJpqlId(1);
        System.out.println(u);
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
        System.out.println("----------------");
        System.out.println(JSON.toJSONString(dtos));
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


    @Test
    public void testStringCon(){
        String a = "aaa";
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"a");
    }

}
