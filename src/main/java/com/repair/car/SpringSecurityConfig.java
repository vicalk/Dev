package com.repair.car;

import com.repair.car.Security.LoginAuthenticationProvider;
import com.repair.car.Security.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginAuthenticationProvider loginAuthenticationProvider;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()

                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(loginSuccessHandler)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll()

                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
//                .antMatchers("/admin").hasAnyAuthority("ADMIN")
//                .antMatchers("/user").hasAnyAuthority("SIMPLE")
                .antMatchers("**/css/**").permitAll()
                .antMatchers("/navbar.ftl").permitAll()
//
                .and()
                .authenticationProvider(loginAuthenticationProvider);
    }
}
