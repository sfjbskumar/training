package com.pension.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class PensionSecurity extends WebSecurityConfigurerAdapter {
    private static final String ADMIN = "ADMIN";
    private static final String PWD = "{noop}password";
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/create/applicant").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.PUT, "/edit/applicant").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.PUT, "/issuePension").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.PUT, "/loadPension").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.PUT, "/approve/{id}").hasAnyRole(ADMIN)
                .and().csrf().disable().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user123").password(PWD).roles("USER").and()
                .withUser("admin123").password(PWD).roles(ADMIN).and().withUser("test123")
                .password(PWD).roles("USER").and().withUser("sathya").password(PWD)
                .roles(ADMIN);
    }
}
