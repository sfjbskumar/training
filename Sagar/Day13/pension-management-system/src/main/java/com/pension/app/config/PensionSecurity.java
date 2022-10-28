package com.pension.app.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
class PensionSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/add").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/all/employee").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/employee/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/update").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/penStatus/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/empStatus/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/add/penAmt").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/getBalance/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/issue/pension/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/approve/{id}").hasAnyRole("ADMIN").and().csrf().disable().headers()
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