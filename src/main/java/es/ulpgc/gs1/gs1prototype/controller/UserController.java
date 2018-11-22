package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.Gs1prototypeApplication;
import es.ulpgc.gs1.gs1prototype.model.DTO.UserDTO;
import es.ulpgc.gs1.gs1prototype.model.user.User;
import es.ulpgc.gs1.gs1prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@CrossOrigin(origins = Gs1prototypeApplication.APIURL)
public class UserController {

    private UserService userService;
    private static final String userPath = "/users";

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

    @PostMapping(userPath)
    public void addUser(@RequestBody UserDTO user){
        userService.add(user);
    }

}
