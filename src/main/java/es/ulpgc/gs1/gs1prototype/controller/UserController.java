package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.DTO.UserDTO;
import es.ulpgc.gs1.gs1prototype.model.user.User;
import es.ulpgc.gs1.gs1prototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @GetMapping(userPath+ "/{username}")
    public User getUserGivenUsername(@PathVariable String username){
        return userService.getGivenUsername(username);
    }

    @PostMapping(userPath)
    public void addUser(@RequestBody UserDTO user){
        userService.add(user);
    }

    @PutMapping(userPath + "/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDTO user) {
        userService.updateUser(id, user);
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
