package es.ulpgc.gs1.gs1prototype.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, length = 60)
    private String password;
    @Column(name = "available")
    private boolean isAvailable;
    private String specialty;
    @OneToOne(fetch = FetchType.EAGER)
    private Profile profile;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;

    public Vet(){}

    public Vet(Profile profile, String username, String password, Set<Role> roles, boolean isAvailable, String specialty) {
        this.profile = profile;
        this.username = username;
        this.password = password;
        this.isAvailable = isAvailable;
        this.roles = roles;
        this.specialty = specialty;
    }

    public String getPassword() {
        return password;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
