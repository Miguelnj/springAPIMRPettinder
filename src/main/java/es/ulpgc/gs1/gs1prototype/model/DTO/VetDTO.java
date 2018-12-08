package es.ulpgc.gs1.gs1prototype.model.DTO;

import es.ulpgc.gs1.gs1prototype.model.Pet;
import es.ulpgc.gs1.gs1prototype.model.user.Profile;
import es.ulpgc.gs1.gs1prototype.model.user.Role;

import java.util.Set;

public class VetDTO {


    private String username;
    private String password;
    private boolean isAvailable;
    private String specialty;
    private Profile profile;
    private Set<Role> roles;

    public VetDTO(String username, String password, boolean isAvailable, String specialty, Profile profile, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.isAvailable = isAvailable;
        this.specialty = specialty;
        this.profile = profile;
        this.roles = roles;
    }

    public VetDTO(){}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getSpecialty() {
        return specialty;
    }

    public Profile getProfile() {
        return profile;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
