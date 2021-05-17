package com.surittec.avaliacao.api.usuario;

import com.surittec.avaliacao.api.security.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean isUserAdmin() {
        return hasRole(UserRoles.ADMIN);
    }

    public boolean isUserComum() {
        return hasRole(UserRoles.COMUM);
    }

    private boolean hasRole(final UserRoles roles) {
        final UserDetails user = getUser();
        return user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(item -> item.equalsIgnoreCase(roles.getDescricao()));

    }

    private UserDetails getUser() {
        final String login = SecurityUtils.getCurrentUserLogin()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario nao esta logado"));

        final User user = userRepository
                .findByLogin(login)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario " + login + " nao encontrado"));

        return new UserDetailsImpl(user);
    }
}
