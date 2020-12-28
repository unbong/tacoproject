package com.example.tacoproject.Secure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Slf4j
@Configuration
//@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguler extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailService;

    @Bean
    public PasswordEncoder encoder(){
        return new StandardPasswordEncoder("53cr3t");
    }

//    protected void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.userDetailsService(userDetailService).passwordEncoder(encoder());
//    }

    @Override
    protected  void configure(HttpSecurity http) throws Exception
    {
        log.info("httt security configure");
        http.authorizeRequests()
                .antMatchers("/design","/orders").access("hasRole('ROLE_USER')")
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/","/*").access("permitAll")
                .and()
                .formLogin().loginPage("/login");

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }


}
