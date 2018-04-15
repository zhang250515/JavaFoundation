package orm;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ZhangQ on 2018/4/15.
 */
public interface AddressRepository extends CrudRepository<Address,Integer> {

    Address getById(Integer id);
}
