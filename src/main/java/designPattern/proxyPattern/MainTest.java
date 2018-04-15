package designPattern.proxyPattern;

import designPattern.proxyPattern.cglib.CglibProxyFactory;
import designPattern.proxyPattern.dynamicProxy.ProxyFactory;
import designPattern.proxyPattern.staticProxy.IUserDao;
import designPattern.proxyPattern.staticProxy.UserDao;
import designPattern.proxyPattern.staticProxy.UserDaoProxy;

/**
 * Created by ZhangQ on 2018/4/3.
 */
public class MainTest {

    public static void main(String[] args) {
        /*IUserDao dao = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(dao);
        proxy.save();
        System.out.println(dao.getClass());
        IUserDao proxyDynamic = (IUserDao) new ProxyFactory(dao).getProxyInstance();
        System.out.println(proxyDynamic.getClass());
        proxyDynamic.save();*/

        UserDao dao = new UserDao();
        UserDao proxy = (UserDao) new CglibProxyFactory(dao).getProxyInstance();
        proxy.save();
    }
}
