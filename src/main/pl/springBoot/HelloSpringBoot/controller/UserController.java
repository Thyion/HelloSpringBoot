package pl.springBoot.HelloSpringBoot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.springBoot.HelloSpringBoot.classes.User;
import pl.springBoot.HelloSpringBoot.interfaces.UserRepository;

@RestController
public class UserController {


    @Autowired
    public UserRepository userRepository;

    @Autowired
    private User user;

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public User showUser() {
        return new User("Janusz", "Kowalski", "janusz@wp.pl");
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    @ResponseBody
    public String testMethod() {
        StringBuilder response = new StringBuilder();
        User user = new User("Janusz", "Kowalik", "janusz@wp.pl");
        userRepository.save(user);
        for(User i: userRepository.findAll()) {
            response.append(i).append("<br>");
        }

        return response.toString();
    }
}
