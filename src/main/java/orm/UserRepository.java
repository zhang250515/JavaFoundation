package orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * Created by ZhangQ on 2018/4/15.
 */
public interface UserRepository extends JpaRepository<User,Integer> {


    @Query(value = "select * from user1 where id = ?1",nativeQuery = true)
    User testId(Integer id);

    @Query(value = "from user1 where id = :id")
    User testJpqlId(@Param("id") Integer id);


}
