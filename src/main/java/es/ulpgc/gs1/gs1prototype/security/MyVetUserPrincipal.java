package es.ulpgc.gs1.gs1prototype.security;

import es.ulpgc.gs1.gs1prototype.model.user.Role;
import es.ulpgc.gs1.gs1prototype.model.user.User;
import es.ulpgc.gs1.gs1prototype.model.user.Vet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyVetUserPrincipal implements UserDetails {

    private Vet vetUser;

    public MyVetUserPrincipal(final Vet user){
        this.vetUser = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (Role role : vetUser.getRoles()) {
            authorityList.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorityList;
    }

    @Override
    public String getPassword() {
        return vetUser.getPassword();
    }

    @Override
    public String getUsername() {
        return vetUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
