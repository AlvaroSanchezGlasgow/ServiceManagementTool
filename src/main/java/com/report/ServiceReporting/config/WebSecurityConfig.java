package com.report.ServiceReporting.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// @formatter:off
	
	PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
	
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	public DataSource getDataSource() {

	    // i was hoping this was going to pull my current datasource, as 
	    // defined in application.properties
	    return DataSourceBuilder
	            .create()
	            .build();
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.authorizeRequests().antMatchers("/home").hasRole("ADMIN")
		.and()
		.logout().deleteCookies("rememberme").permitAll()
		.and()
		.rememberMe().tokenValiditySeconds(60);
	}
	// @formatter:on

	// @formatter:off
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("1234").roles("USER");
		/*auth.jdbcAuthentication()
        .dataSource(getDataSource())
        .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
        .authoritiesByUsernameQuery("SELECT username, role FROM user_roles WHERE username = ?");
		*/
}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    
	        return encoder;
	    
	}
}