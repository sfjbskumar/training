package com.pension.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;


@Component

@Configuration

@EnableWebSecurity
public class PensionSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/add").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/all/employee").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/employee/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/pension/{id}").hasRole("ADMIN")
                //.antMatchers(HttpMethod.GET, "/penStatus/{id}").hasAnyRole("USER","ADMIN")
                //.antMatchers(HttpMethod.GET, "/empStatus/{id}").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.PUT, "/add/penAmt").hasRole("ADMIN")
                //.antMatchers(HttpMethod.GET, "/getBalance/{id}").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.PUT, "/approve/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/issue/pension/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/lastPension").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/delete/pension/{id}").hasRole("ADMIN").and().csrf().disable().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user123").password("{noop}password").roles("USER").and()
                .withUser("admin123").password("{noop}password").roles("ADMIN").and().withUser("test123")
                .password("{noop}password").roles("USER").and().withUser("ramashanker").password("{noop}password")
                .roles("ADMIN");
    }
}
