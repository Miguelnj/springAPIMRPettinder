package es.ulpgc.gs1.gs1prototype.model.user;

import es.ulpgc.gs1.gs1prototype.model.Thread;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, length = 60)
    private String password;
    private String petName;
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private Profile profile;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Thread> initiatedThreads;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Thread> threadOnWhichParticipates;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(){}

    public User(Profile profile, String username, String password, Set<Role> roles) {
        this.profile = profile;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public void addToInitiatedThreads(Thread threadToAdd){
        initiatedThreads.add(threadToAdd);
    }

    public void addToThreadOnWhichParticipates(Thread threadToAdd){
        threadOnWhichParticipates.add(threadToAdd);
        initiatedThreads.add(threadToAdd);
    }

    public Long getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setInitiatedThreads(Set<Thread> initiatedThreads) {
        this.initiatedThreads = initiatedThreads;
    }

    public void setThreadOnWhichParticipates(Set<Thread> threadOnWhichParticipates) {
        this.threadOnWhichParticipates = threadOnWhichParticipates;
    }

    public void setProfile(Profile newProfile) {
        this.profile = newProfile;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
