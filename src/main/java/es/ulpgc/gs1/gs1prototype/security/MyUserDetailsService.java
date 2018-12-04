package es.ulpgc.gs1.gs1prototype.security;

import es.ulpgc.gs1.gs1prototype.model.user.User;
import es.ulpgc.gs1.gs1prototype.model.user.Vet;
import es.ulpgc.gs1.gs1prototype.repository.UserRepository;
import es.ulpgc.gs1.gs1prototype.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final VetRepository vetRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository, VetRepository vetRepository) {
        this.userRepository = userRepository;
        this.vetRepository = vetRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        Vet vetUser = vetRepository.findByUsername(username);
        if(user != null) return new MyUserPrincipal(user);
        if(vetUser != null)return new MyVetUserPrincipal(vetUser);
        throw new UsernameNotFoundException(username);
    }

}
