package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.Gs1prototypeApplication;
import es.ulpgc.gs1.gs1prototype.model.DTO.UserDTO;
import es.ulpgc.gs1.gs1prototype.model.user.User;
import es.ulpgc.gs1.gs1prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = Gs1prototypeApplication.APIURL, maxAge = 4800, allowCredentials = "true")
public class UserController {

    private UserService userService;
    public static final String userPath = "/users";
    public static final String loginPath = "/login";

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

    @PostMapping(loginPath)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }
}
