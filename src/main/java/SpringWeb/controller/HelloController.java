package SpringWeb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import orm.User;
import orm.UserRepository;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private UserRepository repository;

    @GetMapping("/jpa")
    public String testJpa(){
        User user = new User();
        user.setId(1);
        user.setName("Jack");
        user.setPassword(123);
        return repository.save(user).toString();
    }
}
