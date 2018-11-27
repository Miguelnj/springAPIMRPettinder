package es.ulpgc.gs1.gs1prototype.service;


import es.ulpgc.gs1.gs1prototype.model.DTO.UserDTO;
import es.ulpgc.gs1.gs1prototype.model.user.Profile;
import es.ulpgc.gs1.gs1prototype.model.user.Role;
import es.ulpgc.gs1.gs1prototype.model.user.User;
import es.ulpgc.gs1.gs1prototype.repository.ProfileRepository;
import es.ulpgc.gs1.gs1prototype.repository.UserRepository;
import es.ulpgc.gs1.gs1prototype.security.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private UserRepository userRepository;
    private ProfileRepository profileRepository;

    @Autowired
    public UserService(UserRepository userRepository, ProfileRepository profileRepository){
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void add(UserDTO user) {

        Profile newProfile = user.getProfile();
        newProfile = profileRepository.save(newProfile);

        userRepository.save(
                new User(newProfile,
                        user.getUsername(),
                        new BCryptPasswordEncoder(11).encode(user.getPassword()),
                        new HashSet<>(Arrays.asList(new Role("ROLE_ADMIN"), new Role("ROLE_USER"))))
        );
    }

    public User getGivenUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void updateUser(Long id, UserDTO user) {
        User userToChange = get(id);
        if (userToChange == null) return;

        if(user.getPassword() != null){
            userToChange.setPassword(new BCryptPasswordEncoder(11).encode(user.getPassword()));
        }

        if(user.getProfile() != null){
            Profile newProfile = user.getProfile();
            profileRepository.deleteById(userToChange.getProfile().getId());
            newProfile = profileRepository.save(newProfile);
            userToChange.setProfile(newProfile);
        }

        if(user.getRoles() != null) setNewRoles(user, userToChange);

        userRepository.save(userToChange);
    }

    private void setNewRoles(UserDTO user, User userToChange) {
        userToChange.setRoles(user.getRoles());
        changeCurrentRoles(user, userToChange, loggedUser());
    }

    private MyUserPrincipal loggedUser() {
        return (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    private void changeCurrentRoles(UserDTO user, User userToChange, MyUserPrincipal loggedUser) {
        if(loggedUser.getUsername().equals(userToChange.getUsername())){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            List<GrantedAuthority> newAuthorities = new ArrayList<>();
            for (Role role : user.getRoles()) {
                newAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(),auth.getCredentials(),
                    newAuthorities);
            SecurityContextHolder.getContext().setAuthentication(newAuth);
        }
    }

}
