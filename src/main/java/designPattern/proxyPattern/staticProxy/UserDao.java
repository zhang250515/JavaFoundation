package designPattern.proxyPattern.staticProxy;

/**
 * Created by ZhangQ on 2018/4/3.
 */
public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("UserDao Save");
    }
}
