package com.pension.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class PensionSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/createApplicant").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/editApplicant").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/pensions").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/getPensions").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/pension/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/issuePension/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/loadBalance/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/approve/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/checkStatus/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, "/checkBalance/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, "/checkApplication/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, "/pension/{id}").hasAnyRole("ADMIN").and().csrf().disable().headers()
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
