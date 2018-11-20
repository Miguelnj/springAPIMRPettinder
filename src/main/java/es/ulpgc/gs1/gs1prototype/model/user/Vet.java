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
    @OneToOne(fetch = FetchType.EAGER)
    private Profile profile;

    public Vet(){}

    public Vet(Profile profile, String username, String password, Set<Role> roles) {
        this.profile = profile;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Vet(String username, String password, Profile profile) {
        this.username = username;
        this.password = password;
        this.profile = profile;
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
}
