package designPattern.proxyPattern.staticProxy;

/**
 * Created by ZhangQ on 2018/4/3.
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao dao;
    public UserDaoProxy(IUserDao dao){
        this.dao = dao;
    }

    @Override
    public void save() {
        dao.save();
    }
}
