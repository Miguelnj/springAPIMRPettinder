package es.ulpgc.gs1.gs1prototype.controller;

import es.ulpgc.gs1.gs1prototype.model.DTO.UserDTO;
import es.ulpgc.gs1.gs1prototype.model.user.User;
import es.ulpgc.gs1.gs1prototype.model.user.Vet;
import es.ulpgc.gs1.gs1prototype.service.UserService;
import es.ulpgc.gs1.gs1prototype.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private UserService userService;
    private VetService vetService;
    public static final String userPath = "/users";
    public static final String loginPath = "/login";

    @Autowired
    public UserController(UserService userService, VetService vetService){
        this.userService = userService;
        this.vetService = vetService;
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

    /*@PostMapping(loginPath)
    public Boolean login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");


        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return true;
    }*/

    @PostMapping(loginPath)
    public Boolean login(@RequestParam("username") String username, @RequestParam("password") String password){
        User user = userService.getGivenUsername(username);
        if(user != null){
            return new BCryptPasswordEncoder().matches(password, user.getPassword());
        }
        Vet vet = vetService.getByUsername(username);
        if(vet != null){
            return new BCryptPasswordEncoder().matches(password, vet.getPassword());
        }
        return false;
    }
}
