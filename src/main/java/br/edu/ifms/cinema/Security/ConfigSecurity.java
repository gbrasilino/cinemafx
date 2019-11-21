package br.edu.ifms.cinema.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * ConfigSecurity
 */
@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity auth) throws Exception {
        //HTTP Basic authentication
        auth
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/filme/**").hasRole("USER")
        .antMatchers(HttpMethod.POST, "/cad-filme").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/cad-filme/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/delete-filme/**").hasRole("ADMIN")
        .and()
        .csrf().disable()
        .formLogin().disable();

    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("{noop}user")
                .roles("USER");
    }
    // noop é para dizer que a senha não será criptografada
    
}