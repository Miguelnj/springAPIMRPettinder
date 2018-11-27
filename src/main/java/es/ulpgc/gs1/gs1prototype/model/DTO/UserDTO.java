package es.ulpgc.gs1.gs1prototype.model.DTO;

import es.ulpgc.gs1.gs1prototype.model.user.Profile;
import es.ulpgc.gs1.gs1prototype.model.user.Role;

import java.util.Set;

public class UserDTO {

    private String username;
    private String password;
    private Profile profile;
    private Set<Role> roles;

    public UserDTO(String username, String password, Profile profile, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.roles = roles;
    }

    public UserDTO(){}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Profile getProfile() {
        return profile;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
