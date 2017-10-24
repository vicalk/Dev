package com.repair.car.Security;


import com.google.common.collect.ImmutableList;
import com.repair.car.domain.User;
import com.repair.car.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(LoginAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email =  authentication.getName();
        String password = (String) authentication.getCredentials();

        User retrievedUser = userService.login(email, password);
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(retrievedUser.getUserType());

        LOG.info("Logged in user role " + retrievedUser.getUserType());
        return new UsernamePasswordAuthenticationToken(email, password, ImmutableList.of(grantedAuthority));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}