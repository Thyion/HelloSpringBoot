package pl.springBoot.HelloSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.springBoot.HelloSpringBoot.classes.LoginForm;
import pl.springBoot.HelloSpringBoot.classes.User;
import pl.springBoot.HelloSpringBoot.interfaces.UserRepository;

@Controller
public class LoginController {

    @Autowired
    public UserRepository userRepository;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name="loginForm")LoginForm loginForm, Model model) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();



        User baseUser = userRepository.checkUserInBase(username);

            if (baseUser!=null){
                return "home";
            }

        model.addAttribute("invalidCredentials", true);
        return "login";

    }

}
