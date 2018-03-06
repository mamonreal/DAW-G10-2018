package com.daw.apimeals.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UserRepositoryAuthProvider authenticationProvider;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
    
	// Public pages
	http.authorizeRequests().antMatchers("/").permitAll();
    http.authorizeRequests().antMatchers("/login").permitAll();
    http.authorizeRequests().antMatchers("/loginerror").permitAll();
    http.authorizeRequests().antMatchers("/logout").permitAll();
    http.authorizeRequests().antMatchers("/user").permitAll();
    
    // Private pages
    http.authorizeRequests().antMatchers("/afterLog").hasAnyRole("USER");
	http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");	
	//http.authorizeRequests().anyRequest().permitAll();
	
    // Login form
    http.formLogin().loginPage("/user");
    http.formLogin().usernameParameter("name");
    http.formLogin().passwordParameter("password");
    http.formLogin().defaultSuccessUrl("/user");
    http.formLogin().failureUrl("/loginerror");

    // Logout
    http.logout().logoutUrl("/logout");
    http.logout().logoutSuccessUrl("/");
    
    // Disable CSRF at the moment
    http.csrf().disable();
}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.authenticationProvider(authenticationProvider);
}

}
