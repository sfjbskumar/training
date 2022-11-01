package com.pension.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class PensionSecurity extends WebSecurityConfigurerAdapter {

    public  static final String A = "ADMIN";
    public static final String N = "{noop}password";
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/create/applicant").hasAnyRole("A")
                .antMatchers(HttpMethod.POST, "/edit/applicant").hasAnyRole("A")
                .antMatchers(HttpMethod.PUT, "/issuePension/{id}").hasAnyRole("A")
                .antMatchers(HttpMethod.PUT, "/loadPension/{id}").hasAnyRole("A")
                .antMatchers(HttpMethod.PUT, "/approve/{id}").hasAnyRole("A")
                .antMatchers(HttpMethod.GET, "/checkStatus/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, "/checkBalance/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, "/checkApplication/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, "/pension/{id}").hasAnyRole("A").and().csrf().disable().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user123").password("N").roles("USER").and()
                .withUser("admin123").password("N").roles("A").and().withUser("test123")
                .password("N").roles("USER").and().withUser("ramashanker").password("N")
                .roles("A");
    }
}
