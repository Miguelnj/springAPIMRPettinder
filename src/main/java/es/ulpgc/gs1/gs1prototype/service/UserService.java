package es.ulpgc.gs1.gs1prototype.service;


import es.ulpgc.gs1.gs1prototype.model.DTO.UserDTO;
import es.ulpgc.gs1.gs1prototype.model.user.Profile;
import es.ulpgc.gs1.gs1prototype.model.user.Role;
import es.ulpgc.gs1.gs1prototype.model.user.User;
import es.ulpgc.gs1.gs1prototype.repository.ProfileRepository;
import es.ulpgc.gs1.gs1prototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

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
}
