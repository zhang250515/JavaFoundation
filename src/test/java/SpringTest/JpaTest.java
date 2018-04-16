package SpringTest;

import Utils.PermToDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import orm.*;

import java.util.*;

/**
 * Created by ZhangQ on 2018/4/13.
 */
public class JpaTest extends BaseSpringTest{

    @Autowired
    UserRepository repository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PermRepository permRepository;

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
}
