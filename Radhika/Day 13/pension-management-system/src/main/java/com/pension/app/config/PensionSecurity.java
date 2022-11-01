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
    private static final String NPASS = "{noop}password";

    static final String PENSID = "/pension/{id}";
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/createApplicant").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.POST, "/editApplicant").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.GET, "/pensions").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.GET, "/getPensions").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.GET, PENSID).hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.DELETE, PENSID).hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.GET, "/issuePensions").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.PUT, "/issuePension/{id}").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.PUT, "/loadBalance/{id}").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.PUT, "/approve/{id}").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.PUT, "/approve").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.GET, "/checkStatus/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, "/checkBalance/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, "/checkApplication/{id}").hasAnyRole("USER")
                .antMatchers(HttpMethod.GET, PENSID).hasAnyRole(ADMIN).and().csrf().disable().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user123").password(NPASS).roles("USER").and()
                .withUser("admin123").password(NPASS).roles(ADMIN).and().withUser("test123")
                .password(NPASS).roles("USER").and().withUser("ramashanker").password(NPASS)
                .roles(ADMIN);
    }
}
