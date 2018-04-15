package orm;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ZhangQ on 2018/4/15.
 */
public interface UserRepository extends CrudRepository<User,Integer> {

    User getById(Integer id);

    @Query(value = "select * from user1 where id = ?1",nativeQuery = true)
    User testId(Integer id);

    @Query(value = "from user1 where id = :id")
    User testJpqlId(@Param("id") Integer id);

}
