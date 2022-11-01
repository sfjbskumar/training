package com.student.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class PensionSecurity extends WebSecurityConfigurerAdapter {
    String admin="ADMIN";
    String applicant="APPLICANT";
    String password="{noop}password";
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/checkApplication/{id}").hasAnyRole(applicant)
                .antMatchers(HttpMethod.GET, "/checkBalance/{id}").hasAnyRole(applicant)
                .antMatchers(HttpMethod.GET, "/checkStatus/{id}").hasAnyRole(applicant)
                .antMatchers(HttpMethod.POST, "/create/applicant").hasAnyRole(admin)
                .antMatchers(HttpMethod.GET, "/pension").hasAnyRole(admin)
                .antMatchers(HttpMethod.PUT, "/editApplicant").hasAnyRole(admin)
                .antMatchers(HttpMethod.DELETE, "/delete/applicant/{id}").hasAnyRole(admin)
                .antMatchers(HttpMethod.PUT, "/approve/{id}").hasAnyRole(admin)
                .antMatchers(HttpMethod.PUT, "/issuePensionById/{id}").hasAnyRole(admin)
                .antMatchers(HttpMethod.PUT, "/issuePensions").hasAnyRole(admin)
                .antMatchers(HttpMethod.PUT, "/loadBalanceById/{id}").hasAnyRole(admin)
                .antMatchers(HttpMethod.PUT, "/loadBalance").hasAnyRole(admin).and().csrf().disable().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user123").password(password).roles(applicant).and()
                .withUser("admin123").password(password).roles(admin).and().withUser("test123")
                .password(password).roles(applicant).and().withUser("ramashanker").password(password)
                .roles(admin);
    }
}
