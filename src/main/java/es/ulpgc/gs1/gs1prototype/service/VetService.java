package es.ulpgc.gs1.gs1prototype.service;


import es.ulpgc.gs1.gs1prototype.model.DTO.UserDTO;
import es.ulpgc.gs1.gs1prototype.model.DTO.VetDTO;
import es.ulpgc.gs1.gs1prototype.model.user.Profile;
import es.ulpgc.gs1.gs1prototype.model.user.Role;
import es.ulpgc.gs1.gs1prototype.model.user.Vet;
import es.ulpgc.gs1.gs1prototype.repository.ProfileRepository;
import es.ulpgc.gs1.gs1prototype.repository.VetRepository;
import es.ulpgc.gs1.gs1prototype.security.MyVetUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VetService {

    private VetRepository vetRepository;
    private ProfileRepository profileRepository;

    @Autowired
    public VetService(VetRepository vetRepository){
        this.vetRepository = vetRepository;
    }


    public List<Vet> getAll() {
        return vetRepository.findAll();
    }

    public Vet get(Long id) {
        return vetRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Vet getByUsername(String username){return vetRepository.findByUsername(username);}

    public void update(Long id, VetDTO vet) {
        Vet vetToChange = get(id);
        if (vetToChange == null) return;
        if(vet.getPassword() != null){
            vetToChange.setPassword(new BCryptPasswordEncoder(11).encode(vet.getPassword()));
        }
        if(vet.getUsername() != null) vetToChange.setUsername(vet.getUsername());
        if(vet.getSpecialty() != null) vetToChange.setSpecialty(vet.getSpecialty());
        vetToChange.setAvailable(vet.isAvailable());
        if(vet.getProfile() != null){
            Profile newProfile = vet.getProfile();
            profileRepository.deleteById(vetToChange.getProfile().getId());
            newProfile = profileRepository.save(newProfile);
            vetToChange.setProfile(newProfile);
        }
        if(vet.getRoles() != null) setNewRoles(vet, vetToChange);
        vetRepository.save(vetToChange);
    }

    private void setNewRoles(VetDTO user, Vet userToChange) {
        userToChange.setRoles(user.getRoles());
        changeCurrentRoles(user, userToChange, loggedUser());
    }
    private MyVetUserPrincipal loggedUser() {
        return (MyVetUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    private void changeCurrentRoles(VetDTO user, Vet userToChange, MyVetUserPrincipal loggedUser) {
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
