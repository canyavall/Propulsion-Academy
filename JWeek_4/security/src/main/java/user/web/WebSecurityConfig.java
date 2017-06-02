package user.web;

import static org.springframework.http.HttpMethod.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/", "/favicon.ico", "/css/**", "/images/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/users/**")
			.authorizeRequests()
				.antMatchers(GET, "/**").permitAll()
				.antMatchers(POST, "/**").permitAll()
				.antMatchers(PUT, "/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/**").hasRole("ADMIN")
				.and()
			.csrf().disable()
			.httpBasic();
	}
	
}
