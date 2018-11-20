package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.Gs1prototypeApplication;
import es.ulpgc.gs1.gs1prototype.model.user.User;
import es.ulpgc.gs1.gs1prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = Gs1prototypeApplication.APIURL)
public class UserController {

    private UserService userService;
    public static final String userPath = "/users";

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(userPath)
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping(userPath + "/{id}")
    public User getUser(@PathVariable Long id){
        return userService.get(id);
    }

}
