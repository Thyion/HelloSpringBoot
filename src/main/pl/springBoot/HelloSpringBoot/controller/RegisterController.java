package pl.springBoot.HelloSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.springBoot.HelloSpringBoot.Services.EmailSenderImpl;
import pl.springBoot.HelloSpringBoot.classes.RegisterForm;
import pl.springBoot.HelloSpringBoot.classes.User;
import pl.springBoot.HelloSpringBoot.interfaces.EmailSender;
import pl.springBoot.HelloSpringBoot.interfaces.UserRepository;

@Controller
public class RegisterController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public EmailSender emailSender;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterForm(){
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute(name="registerForm") RegisterForm registerForm, Model model) {

        String username = registerForm.getUsername();
        String password = registerForm.getPassword();
        String password2 = registerForm.getPassword2();
        String email = registerForm.getEmail();
        User baseUser = userRepository.checkUserInBase(username);



        if(password.equals(password2) && baseUser==null) {
            User user = new User(username, password, email);
            userRepository.save(user);
            emailSender.sendEmail(email, "rejestracja", "Siemanko");

            return "login";
        }else{
            model.addAttribute("invalidCredentials", true);
            return "register";
        }




    }

}
