package edu.depaul.cdm.se452.se452demo.concepts.security.inmemory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
@Configuration
*/
public class WebSecurityConfigNoRole {
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
			.username("user")
			.password(passwordEncoder().encode("password"))
			.roles("")
			.build();
		UserDetails admin = User.builder()
			.username("admin")
			.password(passwordEncoder().encode("password"))
			.roles("")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }    
	
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
  
      authProvider.setUserDetailsService(users());
      authProvider.setPasswordEncoder(passwordEncoder());
  
      return authProvider;
    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
				.authorizeHttpRequests().requestMatchers("/api/auth/**").permitAll()
				.requestMatchers("/api/test/**").permitAll()
				.requestMatchers("/h2-console/**").permitAll()
				.requestMatchers("/swagger-ui/**").permitAll()
				.and().formLogin();

		// fix H2 database console: Refused to display ' in a frame because it set
		// 'X-Frame-Options' to 'deny'
		http.headers().frameOptions().sameOrigin();

		http.authenticationProvider(authenticationProvider());
		return http.build();
	}	

}
