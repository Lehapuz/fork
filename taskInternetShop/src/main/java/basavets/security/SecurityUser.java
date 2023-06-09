package basavets.security;


import basavets.beans.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SecurityUser implements UserDetails {

    private final String username;
    private final String password;
    private final Set<SimpleGrantedAuthority> authorities;

    public SecurityUser(String username, String password, Set<SimpleGrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

    public static UserDetails fromUser(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                grantedAuthorities);
    }
}
