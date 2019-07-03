/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerceadmindemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author The_Humble_Fool
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserPersistenceService userPersistenceService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/secured/**").hasAuthority("USER").antMatchers("/", "/**").permitAll();
        http.authorizeRequests().anyRequest().hasAuthority("ADMIN");
//        http.formLogin().loginPage("/login").successHandler(successHandler()).failureUrl("/login-error").and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
//        http.formLogin().loginPage("/login").failureUrl("/login-error").and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
        http.formLogin().and().logout().logoutSuccessUrl("/");
        http.httpBasic();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userPersistenceService).passwordEncoder(passwordEncoder());
        auth.inMemoryAuthentication().withUser("admin1").password("{noop}admin123").authorities("ADMIN");
    }
}
