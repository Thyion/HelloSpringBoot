package pl.springBoot.HelloSpringBoot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.springBoot.HelloSpringBoot.classes.User;


@RestController
public class UserService {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User showUser() {
        return new User("Krzychu", "Beszczynski", "krzychu@wp.pl");
    }
}
