package in.hussaincode.userservices.controller;

import in.hussaincode.userservices.entity.User;
import in.hussaincode.userservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        User user =  this.userService.getUser(userId);
        //http://localhost:9001/user/13111
        List contacts= this.restTemplate.getForObject("http://contact-service/contact/user/"+user.getUserId() , List.class);
        user.setContacts(contacts);
        return user;
    }
}
