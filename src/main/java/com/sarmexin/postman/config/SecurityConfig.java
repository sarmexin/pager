package com.sarmexin.postman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Sergey Gavrilov
 */
@EnableWebSecurity
@EnableGlobalAuthentication
// TODO: переделать, так ниже Deprecated
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

    @Bean
    UserDetailsService authentication() {

        UserDetails sergey = User.builder()
                .username("sergey")
                .password(pwEncoder.encode("322132"))
                .roles(ADMIN)
                .build();

        UserDetails natalia = User.builder()
                .username("natalia")
                .password(pwEncoder.encode("322132"))
                .roles(USER)
                .build();

        return new InMemoryUserDetailsManager(sergey, natalia);
    }

    // средство кодирования паролей
    private final PasswordEncoder pwEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/application/save").hasRole(ADMIN)
                .mvcMatchers("/application/read").hasRole(ADMIN)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }


}


