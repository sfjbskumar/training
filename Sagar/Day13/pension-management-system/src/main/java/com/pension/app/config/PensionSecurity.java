package com.pension.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class PensionSecurity extends WebSecurityConfigurerAdapter {
    private static final String ADMIN = "ADMIN";
    private static final String password = "{noop}password";
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/add").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.GET, "/all/employee").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.GET, "/employee/{id}").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.POST, "/update").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.GET, "/pension/{id}").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.GET, "/penStatus/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, "/empStatus/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.PUT, "/add/penAmt").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.GET, "/getBalance/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.PUT, "/approve/{id}").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.PUT, "/issue/pension/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/lastPension").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, "/delete/pension/{id}").hasAnyRole(ADMIN).and().csrf().disable().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user123").password(password).roles("USER").and()
                .withUser("admin123").password(password).roles(ADMIN).and().withUser("test123")
                .password(password).roles("USER").and().withUser("ramashanker").password(password)
                .roles(ADMIN);
    }
}
